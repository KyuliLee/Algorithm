select info.item_id, info.item_name, info.rarity
from item_info AS info
left join item_tree AS tree 
on tree.parent_item_id = info.item_id
where tree.item_id is null
order by info.item_id DESC
