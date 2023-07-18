CREATE TABLE IF NOT EXISTS DEVELOPER_SKILLS (
    DEVELOPER_ID INT NOT NULL,
    SKILL_ID INT NOT NULL,
    PRIMARY KEY (DEVELOPER_ID, SKILL_ID),
    foreign key (DEVELOPER_ID) references developers(id) on delete cascade,
    foreign key (SKILL_ID) references skills(id) on delete cascade
);

