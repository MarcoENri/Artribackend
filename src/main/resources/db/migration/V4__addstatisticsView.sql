CREATE VIEW statistics_view as
SELECT st.*, m.nickname member, s.name song
from member m JOIN statistics st ON m.id = st.member_id JOIN song s ON st.song_id = s.id;