drop view statistics_view;

CREATE VIEW statistics_view as
SELECT st.*, m.email member, s.name song
from member m JOIN statistics st ON m.id = st.member_id JOIN song s ON st.song_id = s.id;

SELECT st.*, CONCAT(m.name, ' ', m.lastname) AS member, s.name AS song
FROM member m
JOIN statistics st ON m.id = st.member_id
JOIN song s ON st.song_id = s.id;

alter table member drop column nickname