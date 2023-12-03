CREATE TABLE tasks (
    task_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    task_description TEXT NOT NULL,
    status VARCHAR(50) DEFAULT 'Pending',
    priority VARCHAR(20),
    task_type VARCHAR(50),
    exp INT NOT NULL,
    created_at DATE,
    due_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

DROP TABLE tasks;

-- Sample tasks for user 1
INSERT INTO tasks (user_id, task_description, priority, task_type, exp, due_date, status)
VALUES
    (1, 'Complete daily coding challenge', 'High', 'Work', 50, '2023-12-10', 'Complete'),
    (1, 'Read a chapter of a book', 'Medium', 'Personal', 30, '2023-12-15', 'Pending'),
    (1, 'Exercise for 30 minutes', 'Low', 'Health', 20, '2023-12-12', 'Complete');

-- Sample tasks for user 2
INSERT INTO tasks (user_id, task_description, priority, task_type, exp, due_date, status)
VALUES
    (2, 'Write a blog post', 'High', 'Work', 40, '2023-12-11', 'Pending'),
    (2, 'Practice playing guitar', 'Medium', 'Hobby', 25, '2023-12-14', 'Complete'),
    (2, 'Prepare for a presentation', 'High', 'Work', 60, '2023-12-13', 'Pending');

-- Sample tasks for user 3
INSERT INTO tasks (user_id, task_description, priority, task_type, exp, due_date, status)
VALUES
    (3, 'Learn a new programming language', 'High', 'Skill Development', 70, '2023-12-09', 'Complete'),
    (3, 'Cook a new recipe', 'Low', 'Personal', 15, '2023-12-16', 'Pending'),
    (3, 'Review and organize emails', 'Medium', 'Productivity', 35, '2023-12-08', 'Complete');
    
SELECT * FROM tasks;
TRUNCATE TABLE tasks;