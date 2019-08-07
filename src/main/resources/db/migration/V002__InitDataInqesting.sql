
INSERT INTO groups (id, group_name, modules)
VALUES (1, 'UserA',
    '[{
      "moduleName":"PromoCard",
      "moduleOrder":1
      },
		{
			"moduleName":"CategoryCard",
			"moduleOrder":2
		},
		{
			"moduleName":"FlashSaleCard",
			"moduleOrder":3
		},
		{
			"moduleName":"HistoryCard",
			"moduleOrder":4
		},
		{
			"moduleName":"NewsCard",
			"moduleOrder":5
		}]'),
(2, 'UserB',
    '[{
      "moduleName":"PromoCard",
      "moduleOrder":1
      },
    {
      "moduleName":"CategoryCard",
      "moduleOrder":2
    },
    {
      "moduleName":"FlashSaleCard",
      "moduleOrder":3
    }]'),
 (3, 'UserA',
    '[{
      "moduleName":"PromoCard",
      "moduleOrder":1
      },
    {
      "moduleName":"CategoryCard",
      "moduleOrder":2
    },
    {
      "moduleName":"FlashSaleCard",
      "moduleOrder":3
    },
    {
      "moduleName":"HistoryCard",
      "moduleOrder":4
    }]');


INSERT INTO users (id, email, name, groups_id)
VALUES(1, 'user1@gamil.com', 'user1', 1),
(2, 'user2@gamil.com', 'user2', 1),
(3, 'user3@gamil.com', 'user3', 2),
(4, 'user4@gamil.com', 'user4', 2),
(5, 'user5@gamil.com', 'user5', 3);