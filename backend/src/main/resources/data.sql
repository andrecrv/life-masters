-- TABLE OPS
-- SELECT * FROM <table-name>; --view data
-- DROP TABLE <table-name>; --delete table
-- TRUNCATE TABLE <table-name>; --clear data

-- USERS
INSERT INTO users (username, password, email, level, title)
VALUES
    ('testing', '123', 'test@devco.com', 1, 'Initiate'),
    ('andrc', '123', 'andc@devco.com', 2, 'Task Tinkerer'),
    ('hugof', '123', 'hfaria@devco.com', 5, 'Productivity Apprentice'),
    ('thethird', '333', 'de.third@devco.com', 10, 'LifeMaster');

-- TASKS user 1
INSERT INTO tasks (user_id, description, priority, task_type, exp, created_at, due_date, status)
VALUES
    (1, 'Complete daily coding challenge', 'High', 'Work', 50, '2023-12-01', '2023-12-10', 'Complete'),
    (1, 'Read a chapter of a book', 'Medium', 'Personal', 30, '2023-12-01', '2023-12-15', 'Pending'),
    (1, 'Exercise for 30 minutes', 'Low', 'Health', 20, '2023-12-01', '2023-12-12', 'Complete');

-- TASKS user 2
INSERT INTO tasks (user_id, description, priority, task_type, exp, created_at, due_date, status)
VALUES
    (2, 'Write a blog post', 'High', 'Work', 40, '2023-12-01', '2023-12-11', 'Pending'),
    (2, 'Practice playing guitar', 'Medium', 'Hobby', 25, '2023-12-01', '2023-12-14', 'Complete'),
    (2, 'Prepare for a presentation', 'High', 'Work', 60, '2023-12-01', '2023-12-13', 'Pending');

-- TASKS user 3
INSERT INTO tasks (user_id, description, priority, task_type, exp, created_at, due_date, status)
VALUES
    (3, 'Learn a new programming language', 'High', 'Skill Development', 70, '2023-12-01', '2023-12-09', 'Complete'),
    (3, 'Cook a new recipe', 'Low', 'Personal', 15, '2023-12-01', '2023-12-16', 'Pending'),
    (3, 'Review and organize emails', 'Medium', 'Productivity', 35, '2023-12-01', '2023-12-08', 'Complete');

-- GOALS user 1
INSERT INTO goals (user_id, description, difficulty, goal_type, exp, created_at, due_date, status)
VALUES
    (1, 'Complete 30 minutes of daily exercise', 'Medium', 'Fitness', 50, '2023-01-01', '2023-02-01', 'Pending'),
    (1, 'Read a book every week', 'Easy', 'Personal Development', 30, '2023-01-05', '2023-03-01', 'Complete'),
    (1, 'Learn a new programming language', 'Hard', 'Skill Development', 100, '2023-02-01', '2023-04-01', 'Pending');

-- GOALS user 2
INSERT INTO goals (user_id, description, difficulty, goal_type, exp, created_at, due_date, status)
VALUES
    (2, 'Meditate for 15 minutes daily', 'Easy', 'Wellness', 30, '2023-01-10', '2023-02-10', 'Complete'),
    (2, 'Complete a coding project', 'Hard', 'Career', 120, '2023-02-15', '2023-05-01', 'Pending'),
    (2, 'Learn to play a musical instrument', 'Medium', 'Hobby', 80, '2023-03-01', '2023-06-01', 'Pending');

-- GOALS user 3
INSERT INTO goals (user_id, description, difficulty, goal_type, exp, created_at, due_date, status)
VALUES
    (3, 'Travel to at least two new countries', 'Hard', 'Adventure', 150, '2023-01-20', '2023-12-31', 'Complete'),
    (3, 'Start a blog and post weekly', 'Medium', 'Creativity', 70, '2023-02-01', '2023-04-01', 'Pending'),
    (3, 'Learn to cook five new recipes', 'Easy', 'Cooking', 40, '2023-03-01', '2023-05-01', 'Pending');
