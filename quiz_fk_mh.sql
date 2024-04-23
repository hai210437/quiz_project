create database quiz_fk_mh;

use quiz_fk_mh;

CREATE TABLE `q_questions` (
                               `q_id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
                               `q_text` varchar(255) NOT NULL
);

CREATE TABLE `a_answers` (
                             `a_id` int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
                             `a_correct` bit(1) DEFAULT NULL,
                             `a_text` varchar(255) DEFAULT NULL,
                             `a_question_id` int(11) DEFAULT NULL
);

ALTER TABLE `a_answers`
    ADD CONSTRAINT `FK_answers_to_questions` FOREIGN KEY (`a_question_id`) REFERENCES `q_questions` (`q_id`);

create table u_user(
                       id INTEGER primary key auto_increment,
                       username varchar(50) not null,
                       score int
);

INSERT INTO `q_questions` (`q_id`, `q_text`) VALUES
                                                 (1, 'What is the capital of France?'),
                                                 (2, 'Which planet is known as the \"Red Planet\"?'),
                                                 (3, 'In which year did Christopher Columbus first reach the Americas?'),
                                                 (4, 'What is the largest mammal on Earth?'),
                                                 (5, 'Who wrote the play \"Romeo and Juliet\"?');


INSERT INTO `a_answers` (`a_id`, `a_correct`, `a_text`, `a_question_id`) VALUES
                                                                             (1, b'0', 'Berlin', 1),
                                                                             (2, b'0', 'Madrid', 1),
                                                                             (3, b'1', 'Paris', 1),
                                                                             (4, b'0', 'Rome', 1),
                                                                             (5, b'0', 'Venus', 2),
                                                                             (6, b'1', 'Mars', 2),
                                                                             (7, b'0', 'Jupiter', 2),
                                                                             (8, b'0', 'Saturn', 2),
                                                                             (9, b'1', '1492', 3),
                                                                             (10, b'0', '1588', 3),
                                                                             (11, b'0', '1620', 3),
                                                                             (12, b'0', '1776', 3),
                                                                             (13, b'0', 'Elephant', 4),
                                                                             (14, b'1', 'Blue Whale', 4),
                                                                             (15, b'0', 'Giraffe', 4),
                                                                             (16, b'0', 'Gorilla', 4),
                                                                             (17, b'0', 'Charles Dickens', 5),
                                                                             (18, b'1', 'William Shakespeare', 5),
                                                                             (19, b'0', 'Jane Austen', 5),
                                                                             (20, b'0', 'Mark Twain', 5);







