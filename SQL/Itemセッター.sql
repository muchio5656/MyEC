SELECT * FROM food_best_much
JOIN
item
ON
food_best_much.item_id = item.id
JOIN
food
ON
food_best_much.food_id = food.id
WHERE food.id = 1