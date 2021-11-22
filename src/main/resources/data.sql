 insert into client(email,first_name,last_name,phone_number)values ('bb@gmail.com','Alexandr','Lipovetskii','+380957088791');
 insert into broker(email,first_name,last_name,phone_number)values ('23@gmail.com','Oleks','Lipovetskii','+3809572388791');
 insert into flat (client_id,broker_id,floor_number,total_area,price,rooms_number,description) values(1,1,2,20,10000,3,'eg');
 insert into flat (client_id,is_broker_accepted,broker_id,floor_number,total_area,price,rooms_number,description) values(1,true,1,2,20,10000,3,'eg');

 select broker_id, COUNT(flat_id) as flat_num from flat f2
                        group by broker_id -- where is_central_firm_approved = false 