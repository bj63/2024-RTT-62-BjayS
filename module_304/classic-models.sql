select * from employees where firstname= 'Diane';
select * FROM employees where job_title= 'Sales rep';

select distinct country from offices;

select distinct firstname from employees order by firstname;

select * from offices;

select count(*) as 'count'
from offices o
where o. country = 'USA';

-- I want to see all employees that work in an office in the USA
select * from employees;
select * from offices;
select e.*, o.city
from employees e, offices o 
where e.office_id = o.id
and o.country = 'USA';


-- lets just start looking at what is in the various tables
select * from orders;
select * from orderdetails;

-- calculate the total price for each line item in the order 10103
select od.*, (quantity_ordered * price_each) as total_price
from orderdetails od
 where order_id = 10103 
 order by order_line_number;

-- now add product name to this query result
select od.*, (quantity_ordered * price_each) as total_price, p. product_name
from orderdetails od, products p
 where order_id = 10103 
 and p. id = od. product_id
 order by order_line_number;

-- now lets add the date of the order
SELECT od.*, (quantity_ordered * price_each) AS total_price, p.product_name, o.order_date
FROM orderdetails od
JOIN products p ON p.id = od.product_id
JOIN orders o ON od.order_id = od.order_id
WHERE od.order_id = 10103
ORDER BY od.order_line_number;

-- now lets add the customer name to this report
select od.*, (quantity_ordered * price_each) as total_price, p. product_name
from orderdetails od, products p
 where order_id = 10103 
 and p. id = od. product_id
 order by order_line_number;



select * from employees;

-- so this is a new question -- 
-- I wamt to see the sum of the total cost for all line items for order line 10103

select sum(quantity_ordered * price_each) as total_order_cost,
max(quantity_ordered) as max_quantity_ordered,
min(quantity_ordered) as min_quantity_ordered,
avg(quantity_ordered * price_each) as average_line_item_cost,
avg(quantity_ordered) as avg_quantity_ordered
from orderdetails od
where order_id = 10103;

select sum(quantity_ordered * price_each) as total_price
from orderdetails od
where order_id = 10103;



-- I want to see the total cost of each order for each order for all orders
select * from orderdetails;

select sum(quantity_ordered * price_each) as total_order_cost,
min(quantity_ordered) as min_qty_ordered,
count(*) as number_of_products
from orderdetails
group by order_id;

-- now i want to see the total amount each customer has spent
-- step 1 was to join the customer table and order table


select c.customer_name, o.id as order_id
from customers c, orders o
where c.id = o.customer_id
order by c.customer_name;

-- Step 2 we need to continue joining over to the order detals table
-- we added a second column to the order by so we could see the products in each by the order id
select c.customer_name, o.id as order_id, od.product_id
from customers c, orders o, orderdetails od
where c.id = o.customer_id
and o.id = od.order_id
order by c.customer_name;

-- Step 3 
select c.customer_name, o.id as order_id, od.product_id, quantity_ordered, price_each, (quantity_ordered * price_each) as line_item_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
and o.id = od.order_id
order by c.customer_name;

-- 
-- 
-- 

select c.id, c.customer_name,sum(quantity_ordered * price_each) as total_customer_spend
from customers c, orders o, orderdetails od
where c.id = o.customer_id
and o.id = od.order_id
group by c.id
order by total_customer_spend desc;

-- to expand the original question to see the sum of each order for each customer
-- 
-- 

select c.id, c.customer_name,o.id as order_id,sum(quantity_ordered * price_each) as total_order_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
and o.id = od.order_id
group by c.id, o.id
order by c.customer_name;

-- Complex step 50k plus
select c.id, c.customer_name,o.id as order_id,sum(quantity_ordered * price_each) as total_order_cost
from customers c, orders o, orderdetails od
where c.id = o.customer_id
and o.id = od.order_id
group by c.id, o.id
having total_order_cost > 50000
order by c.customer_name;

-- Homework 1
-- Question 0.1
-- I want to see the count of the number of products in each product line
select * from productlines;
select * from products where productline_id= 1;

select *
from products p, productlines pl
where p. productline_id = pl.id
group by pl.id ;

-- question 0.2
-- I want to see a list of employees and all of the customers for that employee.   Employee name will be duplicated in the result set.   I want to see the employee first and last name
-- and the customer contact first and last name as well as the customer name
select * from employees;
select * from customers;

select e.id as employee_id, e.firstname, e.lastname
from employess e, customers c
where c.sales_rep_employee_id = e.id
order by e.id;

-- question 0.3
-- I want to see a list of employees in each office.   Show the office name and the employee name
select * from offices;
select * from employees;

select o.city, e.firstname, e.lastname
from offices o, employees e
where o.id = e.office_id
order by o.city;


-- question 0.4
-- I want to see the totaly number of each employee type based on job title.. result should the job title and the number of employess with that job title.
select * from employees;
select job_title, count(*) from employees group by  job_title order by job_title 
-- question 0.5
-- I want to see a list of all payments each customer has made.  Order the list by custoemr name ascending, then by the payment amount descending

-- question 0.6
-- I want to see a list of products that have never been sold.   use ... not in ( select product_id from order_details ) in your where clause
select * from products where id not in ( select product_id from orderdetails ); 

-- question 0.7
-- are there any customers that have never made an order

-- Question 1
-- How many customer are handled by each office.  I want to see the office name and the count of the number of customers in that office.

-- Question 2
-- I want to see the products with the most margin at the top of the table.  Include the product name, buy price, msrp, and margin in the results.  Margin is calculated (MSPR - buy_price) 

-- Question 2.5
-- I want to see the top 5 customers in each state based on margin 

-- Question 3
--  I want to see the top 5 salesmen in the company based on the total amount sold

-- Question 4
-- I want to see the top 5 salesmen based on overall profit (margin)

-- Question 5 
-- I want to see all of the orders that happened in 2004.   You can use a function called year(order_date) = 2004

-- Question 6
-- I want to see the total amount of all orders grouped by the year

-- Question 7
-- I want to see the top 5 products based on quantity sold across all orders

-- question 7.5
-- how many times has each product appeared in an order reguardless of how many were purchased.

-- question 7.6
-- how many products would be out of stock baed on the amount sold acrosss tiem.  -- not sure if the data will spoort this .. basically 
-- looking for any product where the sum of the quantity sold is greater than the quantity in stock

-- question 7.9
-- I want to see the distinct order status ordered alphabetically

-- Question 8
-- I want to see the office name and the distinct product lines that have been sold in that office.  This will require joining almost all of the tables.  
-- select distinct o.name as office_name, pl.productlines as product_line_name  ....


-- for this we can use the format function sba
select p.product_name, format(max(quantity_ordered),2) as max_offer, format(min(quantity_ordered),2) as min_buy_price, 
format(round(avg(quantity_ordered),2),2) as avg_buy_price, count(*) as product_count
from products p, orderdetails od
where p.id = od.product_id
group by od.product_id;

