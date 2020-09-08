
DROP table IF EXISTS ers_reimbursement_status CASCADE;
DROP TABLE IF EXISTS ers_reimbursement_type CASCADE;
DROP table IF EXISTS ers_user_roles CASCADE;
DROP TABLE IF EXISTS ers_users CASCADE;
DROP TABLE IF EXISTS ers_reimbursements CASCADE;



INSERT INTO ers_user_roles (user_role) VALUES
('Financial Manager'),
('Employee');

INSERT INTO ers_reimbursement_status (reimb_status) VALUES
('Pending'),
('Approved'),
('Denied');

INSERT INTO ers_reimbursement_type (reimb_type) VALUES
('Lodging'),
('Travel'),
('Food'),
('Other');




INSERT INTO ers_reimbursement (reimb_amount ,reimb_submitted , reimb_resolved ,reimb_description ,reimb_author, reimb_resolver, reimb_status_id ,reimb_type_id )VALUES
(235, CURRENT_TIMESTAMP, NULL, 'Need some luxurious food', 1, NULL, 1, 3),
(5, '2011-02-09 13:09:00', '2011-02-20 13:09:00', 'No Reason', 1, 2, 3, 4),
(1000000, '2005-12-25 00:00:00', '2005-12-26 00:00:00', 'New Baby', 2, 3, 2, 4),
(2000, '2012-02-03 12:30:00', null, 'For Lodging in 2200', 1, NULL, 1, 1);
