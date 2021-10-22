-- login_users
CREATE TABLE login_users (
    user_id    VARCHAR(20) NOT NULL,
    user_name  VARCHAR(20) NOT NULL,
    password   VARCHAR(20) NOT NULL,
    email      VARCHAR(256) NOT NULL,
    admin_flag CHAR(1) NOT NULL,
    PRIMARY KEY (user_id)
);


-- board_thread_table
CREATE TABLE board_thread_table (
    thread_id       INT(11) NOT NULL AUTO_INCREMENT,
    thread_title    VARCHAR(100) NOT NULL,
    thread_text     VARCHAR(1000) NOT NULL,
    post_user_name  VARCHAR(20) NOT NULL,
    post_date_time  DATETIME NOT NULL,
    PRIMARY KEY (thread_id)
);


-- board_comment_table
CREATE TABLE board_comment_table (
    comment_id      INT(11) NOT NULL AUTO_INCREMENT,
    thread_id       INT(11) NOT NULL,
    thread_comment  VARCHAR(1000) NOT NULL,
    post_user_name  VARCHAR(20) NOT NULL,
    post_date_time  DATETIME NOT NULL,
    PRIMARY KEY (comment_id)
);