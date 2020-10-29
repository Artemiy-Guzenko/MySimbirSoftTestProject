CREATE TABLE IF NOT EXISTS urls
(
    ID    INT          NOT NULL AUTO_INCREMENT,
    PATH   VARCHAR(255) NOT NULL,
    WORD  VARCHAR(255) NOT NULL,
    COUNT INT          NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO urls VALUES ('1', '1url', 'slovo1', '15');
INSERT INTO urls VALUES ('2', '2url', 'slovo2', '5');
INSERT INTO urls VALUES ('3', '3url', 'slovo3', '1');