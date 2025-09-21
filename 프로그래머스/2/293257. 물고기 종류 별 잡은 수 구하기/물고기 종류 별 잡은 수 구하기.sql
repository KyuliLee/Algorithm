select count(fi.fish_type) AS FISH_COUNT, fni.FISH_NAME
from fish_info as fi
join fish_name_info as fni
on fi.fish_type = fni.fish_type
group by fni.fish_name
order by FISH_COUNT DESC

