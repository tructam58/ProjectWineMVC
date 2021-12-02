use wineshop;
create table categories(
	category_id char(50) not null primary key,
	category_name nvarchar(255),
	category_description nvarchar(255),
    category_img nvarchar(255)
);
insert into categories (category_id, category_name,category_img, category_description)
values
("Re","Red","cat1.jpg","Rượu vang đỏ là một dạng phổ biến của rượu vang được làm từ những loại nho đậm màu. Vang đỏ thường có màu đậm pha trộn giữa màu đỏ, đen và tím. Vỏ nho được nghiền nát cùng với ruột để tạo ra nước ép rồi lên men thành rượu."),
("W","White","cat2.jpg","Rượu vang trắng có màu nhạt hơn rượu vang đỏ nhưng không hoàn toàn là màu trắng mà còn có màu vàng, vàng rơm, v.v..Rượu vang trắng có màu nhạt vì nó được chế biến đơn thuần từ nước ép quả nhỏ và không có vỏ hoặc sản xuất từ những quả nho có màu xanh nhạt."),
("R","Rosé", "cat.jpg","Rượu vang hồng được làm bằng giống nho đỏ, nhưng vỏ không nằm lâu trong nước nho (chỉ từ 1 cho tới 3 ngày), do đó loại rượu này không có nhiều vị chát của tannin từ vỏ trái nho như vang đỏ.");

select * from categories;
drop table categories;
create table countries(country_id char(50) not null primary key,
country_name nvarchar(255)
);
insert into countries (country_id, country_name)
values("F","FRANCE"), ("I","ITALY"),("C","CHILE");

select * from countries;




create table products(
	product_id char(50) not null primary key,
	product_name nvarchar(255),
	product_img nvarchar(255),
	product_price decimal(9,3),
	product_description nvarchar(1024),
	created_at datetime,
	updated_at datetime,
	category_id char(50),
	country_id char(50),
	foreign key (category_id) references categories(category_id),
	foreign key (country_id) references countries(country_id)
);
-- Rose
insert into products (product_id, product_name, product_img, product_price, product_description, created_at, updated_at, category_id, country_id)
values 
("R1", "Le Paradou Cinsault", "rose/product19.jpg", 540.000,  "Rượu vang Le Paradou Cinsault với hương thơm quả mọng đỏ, dâu tây, cherry, hòa cùng hương chanh, bưởi, đào và mận chín. Vang có độ chua sống động hòa cùng nhiều tầng hương trái cây tươi mới, mang lại dư vị cân bằng khi thưởng thức."
,"2021-11-23", "2021-11-23", "R", "F"),
 ("R2", "Chateau Haut Dambert rose 2016t", "rose/product3.jpg", 595.000,  "Rượu vang Chateau Haut Dambert rose 2016t với lượng tanin mềm mại và hài hoà một cách hoàn hảo cùng sự phong phú sẽ đem đến trải nghiệm ẩm thực khó quên. Đây là dòng vang mạnh mẽ và tập trung nhưng vẫn có sự mịn màng và tinh tế một cách đặc biệt."
,"2021-11-23", "2021-11-23", "R", "F"),

-- White
("W1", "Kono Marlborough Sauvignon Blanc", "white/product15.jpg", 620.000,  "Rượu Vang Kono Marlborough Sauvignon Blanc sống động tuyệt vời với vị chanh dây tươi mát, dứa mọng nước với ngò gai tươi và hương thơm của lá cà chua nghiền.

Hương vị kéo dài và thơm ngát, kết hợp trái cây ngoại lai với ớt chín đỏ, cùng với ô-liu xanh. Độ cân bằng tuyệt vời bởi vị chanh phảng phất cùng axit tự nhiên dòn dã. Thích hợp dung chung với các món ăn tinh tế và nhẹ nhàng."
,"2021-11-23", "2021-11-23", "W", "C"),
("W2", "Kono Marlborough Sauvignon Blanc", "white/product11.jpg", 620.000,  "Rượu Vang Kono Marlborough Sauvignon Blanc sống động tuyệt vời với vị chanh dây tươi mát, dứa mọng nước với ngò gai tươi và hương thơm của lá cà chua nghiền.

Hương vị kéo dài và thơm ngát, kết hợp trái cây ngoại lai với ớt chín đỏ, cùng với ô-liu xanh. Độ cân bằng tuyệt vời bởi vị chanh phảng phất cùng axit tự nhiên dòn dã. Thích hợp dung chung với các món ăn tinh tế và nhẹ nhàng."
,"2021-11-23", "2021-11-23", "W", "C"),
("W3", "Casa Burti Flûte Dolce", "white/product26.jpg", 565.000,  "Rượu vang nổ Casa Burti Flute Dolce 750ml là một loại rượu vang sủi tăm ngọt ngào với những nốt hương dễ chịu của quả mơ và đào. Sự ngọt ngào và bền bỉ của Dolce làm cho chai rượu càng thêm hoàn hảo với bánh ngọt và bánh nướng.."
,"2021-11-23", "2021-11-23", "W", "I"),
("W4", "Osadia Sauvignon Blanc", "white/product22.jpg", 445.000,  "Rượu vang Osadia Sauvignon Blanc là một trong những dòng vang phổ thông có mặt ở hầu khắp các thị trường được nhiều người tiêu dùng ưa thích và lựa chọn sử dụng phục vụ cho những bữa tiệc nhẹ nhàng thường ngày.Rượu có nồng độ cồn 13,5%, xuất xứ Chile, giống nho Sauvignon Blanc."
,"2021-11-23", "2021-11-23", "W", "C"),
("W5", "Osadia Sauvignon Blanc", "white/product1.jpg", 445.000,  "Rượu vang Osadia Sauvignon Blanc là một trong những dòng vang phổ thông có mặt ở hầu khắp các thị trường được nhiều người tiêu dùng ưa thích và lựa chọn sử dụng phục vụ cho những bữa tiệc nhẹ nhàng thường ngày.Rượu có nồng độ cồn 13,5%, xuất xứ Chile, giống nho Sauvignon Blanc."
,"2021-11-23", "2021-11-23", "W", "C"),
-- Red
("Re1", "Agustinos Reserva, Carmenere", "red/product33.jpg", 595.000,  "Loại rượu này có vẻ ngoài được đánh bóng độc đáo, với quả mâm xôi và quả mọng đen chiếm ưu thế kết hợp với hạt tiêu đen và gia vị được tạo điểm nhấn bởi một chút thuốc lá trên lớp kết thúc ngon ngọt."
,"2021-11-23", "2021-11-23", "Re", "C"),
("Re2", "Agustinos Terra Cabernet Sauvignon", "red/product34.jpg", 715.000,  "Với màu đỏ ruby ​​đậm, loại rượu này có hương thơm trái cây đen mạnh mẽ như dâu đen, hương bạc hà và thảo mộc, nho đen và gia vị. Nó có cấu trúc tốt và nồng độ trái cây lớn trong miệng. Tươi mát và hương trái cây, với một kết thúc lâu dài và bền bỉ."
,"2021-11-23", "2021-11-23", "Re", "C"),
("Re3", "Camperchi Merlot", "red/product35.jpg", 900.000,  "Trên cánh mũi hương thơm của mứt trái cây đỏ và trưởng thành, thêm ghi chú của màu tím. Trên vòm miệng là thanh tao, tannin với cấu trúc tuyệt vời và độ bền lâu."
,"2021-11-23", "2021-11-23", "Re", "I"),
("Re4", "Castelforte Corvina", "red/product29.jpg", 510.000,  "Castelforte Corvina là một loại rượu vang khô, toàn thân có màu đỏ ruby ​​đậm. Nó cho thấy một mùi hương của quả anh đào đen và quả mâm xôi chín với chút vani và gia vị ngọt ngào. Một kết hợp hoàn hảo cho các loại thịt đỏ, trò chơi."
,"2021-11-23", "2021-11-23", "Re", "I"),
("Re5", "Camperchi Sasso Lupaio “Chianti DOCG”", "red/product36.jpg", 660.000,  "Màu đỏ ruby ​​đậm, một chút gia vị. Mềm mại, hài hòa & bền bỉ."
,"2021-11-23", "2021-11-23", "Re", "I");

select *
from products  as p 
left join categories as cat on p.category_id = cat.category_id
join countries as cn on p.country_id = cn.country_id
group by p.category_id,  cn.country_id;


create table users(
	user_id bigint Auto_increment,
	user_fullname varchar(150),
    user_address varchar (255),
    user_phone varchar(10),
    user_email varchar(100),
    user_password varchar(255),
    PRIMARY KEY (user_id) 
);

-- Soobin

create table bills(
	bill_id bigint Auto_increment,
	bill_fullname varchar(150),
    bill_address varchar (255),
    bill_email varchar(100),
    bill_phone varchar(10),
    bill_notes varchar(255),
    bill_total double,
    bill_quanty int,
    PRIMARY KEY (bill_id) 
);

create table billdetail(
	id bigint Auto_increment,
	product_id char(50),
    bill_id bigint,
    bill_quanty int,
    bill_total double,
    
    PRIMARY KEY (id) ,
    foreign key (product_id) references products(product_id),
	foreign key (bill_id) references bills(bill_id)
);

