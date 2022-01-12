
create table team (
	id int not null auto_increment,
    team_name varchar(100),
    wins int,
    losses int,
    primary key (id)
);


create table player (
	id int not null auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    team_id int,
    lineup_id int,
    strikeouts int,
    walks int,
    runs int,
    hits int,
    singles int,
    doubles int,
    triples int,
    homeruns int,
    primary key(id),
    foreign key(team_id) references team(id)
);

create table game (
	id int not null auto_increment,
    away_team_id int,
    home_team_id int,
    away_score int,
    home_score int,
    primary key(id),
    foreign key(away_team_id) references team(id),
    foreign key(home_team_id) references team(id)
);

create table at_bat (
	id int not null auto_increment,
    game_id int,
    player_batting_id int,
    player_on_first_id int,
    player_on_second_id int,
    player_on_third_id int,
    outs int,
    runsScored int,
    away_index int,
    home_index int,
    inning_num int,
    primary key (id),
    foreign key(game_id) references game(id),
    foreign key(player_batting_id) references player(id),
    foreign key(player_on_first_id) references player(id),
    foreign key(player_on_second_id) references player(id),
    foreign key(player_on_third_id) references player(id)
);

create table pitch (
	id int not null auto_increment,
    at_bat_id int,
    strikes int,
    balls int,
    primary key(id),
    foreign key(at_bat_id) references at_bat(id)
);

