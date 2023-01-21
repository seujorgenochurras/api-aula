
CREATE TABLE delivery(
id bigint not null,
client_id bigint not null,
price decimal(10,2),
deliveryDate date not null,
deliveryArrived date,
status varchar(20) not null,
recipient_name varchar(80) not null,
recipient_address varchar(255) not null,
recipient_phone   varchar(30),

primary key (id),
foreign key (client_id) references clients(id)
);