CREATE TABLE goals (
    goal_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    goal_description TEXT NOT NULL,
    status VARCHAR(50) DEFAULT 'Pending',
    difficulty VARCHAR(20),
    goal_type VARCHAR(50),
    exp INT NOT NULL,
    created_at DATE,
    due_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Inserting rows for user_id = 1
INSERT INTO goals (user_id, goal_description, difficulty, goal_type, exp, created_at, due_date)
VALUES
    (1, 'Complete 30 minutes of daily exercise', 'Medium', 'Fitness', 50, '2023-01-01', '2023-02-01'),
    (1, 'Read a book every week', 'Easy', 'Personal Development', 30, '2023-01-05', '2023-03-01'),
    (1, 'Learn a new programming language', 'Hard', 'Skill Development', 100, '2023-02-01', '2023-04-01');

-- Inserting rows for user_id = 2
INSERT INTO goals (user_id, goal_description, difficulty, goal_type, exp, created_at, due_date)
VALUES
    (2, 'Meditate for 15 minutes daily', 'Easy', 'Wellness', 30, '2023-01-10', '2023-02-10'),
    (2, 'Complete a coding project', 'Hard', 'Career', 120, '2023-02-15', '2023-05-01'),
    (2, 'Learn to play a musical instrument', 'Medium', 'Hobby', 80, '2023-03-01', '2023-06-01');

-- Inserting rows for user_id = 3
INSERT INTO goals (user_id, goal_description, difficulty, goal_type, exp, created_at, due_date)
VALUES
    (3, 'Travel to at least two new countries', 'Hard', 'Adventure', 150, '2023-01-20', '2023-12-31'),
    (3, 'Start a blog and post weekly', 'Medium', 'Creativity', 70, '2023-02-01', '2023-04-01'),
    (3, 'Learn to cook five new recipes', 'Easy', 'Cooking', 40, '2023-03-01', '2023-05-01');

SELECT * FROM goals;
DROP TABLE goals;
TRUNCATE TABLE goals;



