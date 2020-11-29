# JavaEE

#WebToDoList Project

The objective of the project is to dynamic web application called “WebToDoList”. That app will allow an instructor to put online a todo list for his students and allow the students to access this todo list.

An authentication interface will first prompt in order to identify, through a login process, if the user is a student or an instructor. Depends on the status of the user, different options will be accessible.
• A student can only read the todo list.
• An instructor can read, add, edit and delete todo on the list.
• An unknow tries to connect to the application, an error message is displayed.
The instructor and all his students have user accounts in the SQL database. The login system verifies his account if it is valid user or not. An account is defined by a username, a password and a role (instructor or student). After the authentication process, the web site creates a cookie for the username after the first login by a new user.
