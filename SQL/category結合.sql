SELECT
i.id,
i.name,
i.detail,
i.price,
i.file_name,
i.item_category_id,
i.create_date,
c.category
FROM
item i
INNER JOIN
item_category c
ON
i.item_category_id = c.id
