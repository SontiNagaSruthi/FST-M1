UPDATE salesman SET grade=200 where salesman_city='Rome';
UPDATE salesman SET grade=300 where salesman_name='James Hoog';
UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';

//displays modified data

SELECT * FROM salesman;