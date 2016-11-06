SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--Definicion de tablas
CREATE TABLE roles (
  id int(2) NOT NULL,
  role_name varchar(20) DEFAULT NULL,
  role_description varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE players (
  id int(3) NOT NULL,
  id_role int(2) DEFAULT NULL,
  username varchar(25) DEFAULT NULL,
  usertoken varchar(255) DEFAULT NULL,
  name varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE teams (
  id int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE match_types (
  id int(2) NOT NULL,
  description varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE results (
  id int(12) NOT NULL,
  winner tinyint(1) DEFAULT NULL,
  mvp tinyint(1) DEFAULT NULL,
  points int(4) DEFAULT NULL,
  goals int(2) DEFAULT NULL,
  assits int(2) DEFAULT NULL,
  safes int(2) DEFAULT NULL,
  shots int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE matches (
  id int(8) NOT NULL,
  id_type int(2) DEFAULT NULL,
  id_team_a int(5) DEFAULT NULL,
  id_team_b int(5) DEFAULT NULL,
  id_tournament int(4) DEFAULT NULL,
  date_played datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tournaments (
  id int(4) NOT NULL,
  start_date datetime DEFAULT NULL,
  end_date datetime DEFAULT NULL,
  id_winner int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE teams_players (
  id_team int(5) NOT NULL,
  id_player int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE match_result_player (
  id_match int(8) NOT NULL,
  id_result int(12) NOT NULL,
  id_player int(3) NOT NULL,
  audit_user_id int(3) DEFAULT NULL,
  audit_date datetime DEFAULT NULL,
  audit_public_ip varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--Definición de índices
ALTER TABLE matches
  ADD PRIMARY KEY (id),
  ADD KEY id_type (id_type),
  ADD KEY id_team_a (id_team_a),
  ADD KEY id_team_b (id_team_b),
  ADD KEY id_tournament (id_tournament);

ALTER TABLE match_result_player
  ADD PRIMARY KEY (id_match,id_result,id_player),
  ADD KEY id_result (id_result),
  ADD KEY id_player (id_player),
  ADD KEY audit_user_id (audit_user_id);

ALTER TABLE match_types
  ADD PRIMARY KEY (id);

ALTER TABLE players
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY username (username),
  ADD KEY id_role (id_role);

ALTER TABLE results
  ADD PRIMARY KEY (id);

ALTER TABLE roles
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY role_name (role_name);

ALTER TABLE teams
  ADD PRIMARY KEY (id);

ALTER TABLE teams_players
  ADD PRIMARY KEY (id_team,id_player),
  ADD KEY id_player (id_player);

ALTER TABLE tournaments
  ADD PRIMARY KEY (id),
  ADD KEY id_winner (id_winner);


ALTER TABLE matches
  MODIFY id int(8) NOT NULL AUTO_INCREMENT;

ALTER TABLE match_types
  MODIFY id int(2) NOT NULL AUTO_INCREMENT;

ALTER TABLE players
  MODIFY id int(3) NOT NULL AUTO_INCREMENT;

ALTER TABLE results
  MODIFY id int(12) NOT NULL AUTO_INCREMENT;

ALTER TABLE roles
  MODIFY id int(2) NOT NULL AUTO_INCREMENT;

ALTER TABLE teams
  MODIFY id int(5) NOT NULL AUTO_INCREMENT;

ALTER TABLE tournaments
  MODIFY id int(4) NOT NULL AUTO_INCREMENT;

ALTER TABLE matches
  ADD CONSTRAINT matches_ibfk_1 FOREIGN KEY (id_type) REFERENCES match_types (id),
  ADD CONSTRAINT matches_ibfk_2 FOREIGN KEY (id_team_a) REFERENCES teams (id),
  ADD CONSTRAINT matches_ibfk_3 FOREIGN KEY (id_team_b) REFERENCES teams (id),
  ADD CONSTRAINT matches_ibfk_4 FOREIGN KEY (id_tournament) REFERENCES tournaments (id);

ALTER TABLE match_result_player
  ADD CONSTRAINT match_result_player_ibfk_1 FOREIGN KEY (id_match) REFERENCES matches (id),
  ADD CONSTRAINT match_result_player_ibfk_2 FOREIGN KEY (id_result) REFERENCES results (id),
  ADD CONSTRAINT match_result_player_ibfk_3 FOREIGN KEY (id_player) REFERENCES players (id),
  ADD CONSTRAINT match_result_player_ibfk_4 FOREIGN KEY (audit_user_id) REFERENCES players (id);

ALTER TABLE players
  ADD CONSTRAINT players_ibfk_1 FOREIGN KEY (id_role) REFERENCES roles (id);

ALTER TABLE teams_players
  ADD CONSTRAINT teams_players_ibfk_1 FOREIGN KEY (id_player) REFERENCES players (id),
  ADD CONSTRAINT teams_players_ibfk_2 FOREIGN KEY (id_team) REFERENCES teams (id);

ALTER TABLE tournaments
  ADD CONSTRAINT tournaments_ibfk_1 FOREIGN KEY (id_winner) REFERENCES players (id);
