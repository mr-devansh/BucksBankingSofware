INSERT INTO department (dept_id, dept_name, location) VALUES (1, 'IT', 'New York');
INSERT INTO department (dept_id, dept_name, location) VALUES (2, 'HR', 'Chicago');
INSERT INTO department (dept_id, dept_name, location) VALUES (3, 'Finance', 'San Francisco');
INSERT INTO department (dept_id, dept_name, location) VALUES (4, 'Marketing', 'Boston');
INSERT INTO department (dept_id, dept_name, location) VALUES (5, 'Operations', 'Seattle');

INSERT INTO project (project_id, project_name, start_date, end_date) VALUES (1, 'Project Alpha', '2023-01-01', '2023-12-31');
INSERT INTO project (project_id, project_name, start_date, end_date) VALUES (2, 'Project Beta', '2023-03-01', '2023-09-30');
INSERT INTO project (project_id, project_name, start_date, end_date) VALUES (3, 'Project Gamma', '2023-05-01', '2024-05-01');

INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (1, 'John Doe', 'john.doe@example.com', 'New York', 75000, '2021-05-01', 1);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (2, 'Jane Smith', 'jane.smith@example.com', 'Chicago', 80000, '2020-09-15', 2);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (3, 'Alice Johnson', 'alice.johnson@example.com', 'San Francisco', 90000, '2019-11-20', 3);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (4, 'Bob Brown', 'bob.brown@example.com', 'Boston', 70000, '2022-01-10', 4);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (5, 'Tom Wilson', 'tom.wilson@example.com', 'Seattle', 72000, '2022-07-01', 5);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (6, 'Chris Lee', 'chris.lee@example.com', 'New York', 85000, '2021-03-15', 1);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (7, 'Emily Davis', 'emily.davis@example.com', 'Chicago', 88000, '2020-11-10', 2);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (8, 'Michael Scott', 'michael.scott@example.com', 'San Francisco', 93000, '2018-05-20', 3);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (9, 'Sarah Parker', 'sarah.parker@example.com', 'Boston', 75000, '2021-08-05', 4);
INSERT INTO employee (emp_id, emp_name, email, city, salary, joining_date, dept_id) VALUES (10, 'Robert King', 'robert.king@example.com', 'Seattle', 78000, '2021-06-15', 5);

INSERT INTO employee_project (emp_id, project_id) VALUES (1, 1);
INSERT INTO employee_project (emp_id, project_id) VALUES (1, 2);
INSERT INTO employee_project (emp_id, project_id) VALUES (2, 2);
INSERT INTO employee_project (emp_id, project_id) VALUES (3, 3);
INSERT INTO employee_project (emp_id, project_id) VALUES (4, 1);
INSERT INTO employee_project (emp_id, project_id) VALUES (5, 1);
INSERT INTO employee_project (emp_id, project_id) VALUES (6, 2);
INSERT INTO employee_project (emp_id, project_id) VALUES (7, 3);
INSERT INTO employee_project (emp_id, project_id) VALUES (8, 1);
INSERT INTO employee_project (emp_id, project_id) VALUES (9, 2);
INSERT INTO employee_project (emp_id, project_id) VALUES (10, 3);
