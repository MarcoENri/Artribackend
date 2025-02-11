CREATE TABLE IF NOT EXISTS statistics(
    id SERIAL,
    date DATE NOT NULL,
    score INT NOT NULL,
    song_id INT NOT NULL,
    member_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(song_id) REFERENCES song(id),
    FOREIGN KEY( member_id) REFERENCES member(id)

)