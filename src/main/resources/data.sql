-- Inserting users
INSERT INTO users (name, user_name, password, age) VALUES
                                                       ('Alice Smith', 'alice_smith', 'password123', '25'),
                                                       ('Bob Johnson', 'bob_johnson', 'password456', '30'),
                                                       ('Charlie Brown', 'charlie_brown', 'password789', '28');

-- Inserting posts
INSERT INTO posts (content_text, likes, image_url, user_id) VALUES
                                                                ('This is my first post!', 10, 'http://example.com/image1.jpg', 1),
                                                                ('Hello world!', 5, 'http://example.com/image2.jpg', 2),
                                                                ('Having a great day!', 20, 'http://example.com/image3.jpg', 3);

-- Inserting user followers
INSERT INTO user_followers (user_id, follower_id) VALUES
                                                      (1, 2),  -- Alice follows Bob
                                                      (1, 3),  -- Alice follows Charlie
                                                      (2, 1);  -- Bob follows Alice
