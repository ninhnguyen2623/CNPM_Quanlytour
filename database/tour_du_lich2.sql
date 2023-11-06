
--
-- Set default database
--
USE tour_du_lich1;

--
-- Drop table `booking_detail`
--
DROP TABLE IF EXISTS booking_detail;

--
-- Drop table `service`
--
DROP TABLE IF EXISTS service;

--
-- Drop table `role_permission`
--
DROP TABLE IF EXISTS role_permission;

--
-- Drop table `permission`
--
DROP TABLE IF EXISTS permission;

--
-- Drop table `booking`
--
DROP TABLE IF EXISTS booking;

--
-- Drop table `customer`
--
DROP TABLE IF EXISTS customer;

--
-- Drop table `tour_detail`
--
DROP TABLE IF EXISTS tour_detail;

--
-- Drop table `place`
--
DROP TABLE IF EXISTS place;

--
-- Drop table `region`
--


--
-- Drop table `tour`
--
DROP TABLE IF EXISTS tour;
DROP TABLE IF EXISTS region;

--
-- Drop table `hotel`
--
DROP TABLE IF EXISTS hotel;

--
-- Drop table `user`
--
DROP TABLE IF EXISTS user;

--
-- Drop table `role`
--
DROP TABLE IF EXISTS role;

--
-- Set default database
--
USE tour_du_lich1;

--
-- Create table `role`
--
CREATE TABLE role (
  role_id int NOT NULL AUTO_INCREMENT,
  role_name varchar(100) DEFAULT NULL,
  PRIMARY KEY (role_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 8,
AVG_ROW_LENGTH = 4096;



--
-- Create table `user`
--
CREATE TABLE user (
  user_id int NOT NULL AUTO_INCREMENT,
  user_name varchar(100) NOT NULL,
  password varchar(100) NOT NULL,
  fullname varchar(100) NOT NULL,
  tel varchar(100) DEFAULT NULL,
  birthday date DEFAULT NULL,
  gender varchar(20) DEFAULT NULL,
  role_id int DEFAULT 4,
  create_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 16,
AVG_ROW_LENGTH = 2730;



--
-- Create index `idx_unq_user_name` on table `user`
--
ALTER TABLE user
ADD UNIQUE INDEX idx_unq_user_name (user_name);

--
-- Create foreign key
--
ALTER TABLE user
ADD CONSTRAINT fk_User_Group FOREIGN KEY (role_id)
REFERENCES role (role_id) ON UPDATE CASCADE ON DELETE SET null;

--
-- Create table `hotel`
--
CREATE TABLE hotel (
  hotel_id int NOT NULL AUTO_INCREMENT,
  hotel_name varchar(100) NOT NULL,
  address text DEFAULT NULL,
  tel varchar(100) DEFAULT NULL,
  website varchar(100) DEFAULT NULL,
  star tinyint DEFAULT 2,
  PRIMARY KEY (hotel_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 13,
AVG_ROW_LENGTH = 8192;


--
-- Create table `region`
--
CREATE TABLE region (
  region_id int NOT NULL AUTO_INCREMENT,
  region_code varchar(100) DEFAULT NULL,
  PRIMARY KEY (region_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 6,
AVG_ROW_LENGTH = 5461;



--
-- Create index `region_code` on table `region`
--
ALTER TABLE region
ADD UNIQUE INDEX region_code (region_code);



--
-- Create table `tour`
--
CREATE TABLE tour (
  tour_id int NOT NULL AUTO_INCREMENT,
  tour_name varchar(100) NOT NULL,
  hotel_id int,
  region_code varchar(100),
  price decimal(20, 4) NOT NULL,
  start_day date DEFAULT NULL,
  end_day date DEFAULT NULL,
  departure_place varchar(100) DEFAULT NULL,
  schedule_describe text DEFAULT NULL,
  create_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (tour_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 8,
AVG_ROW_LENGTH = 2730;



--
-- Create foreign key
--
ALTER TABLE tour
ADD CONSTRAINT fk_Tour_Hotel FOREIGN KEY (hotel_id)
REFERENCES hotel (hotel_id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE tour
ADD CONSTRAINT fk_Tour_Region FOREIGN KEY (region_code)
REFERENCES region (region_code) ON DELETE SET NULL ON UPDATE CASCADE;


--
-- Create table `place`
--
CREATE TABLE place (
  place_id int NOT NULL AUTO_INCREMENT,
  place_name varchar(100) NOT NULL,
  place_describe text DEFAULT NULL,
  place_address varchar(100) DEFAULT '',
  region_code varchar(100),
  place_img varchar(100),
  PRIMARY KEY (place_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 30,
AVG_ROW_LENGTH = 712;



--
-- Create foreign key
--
ALTER TABLE place
ADD CONSTRAINT fk_Place_region FOREIGN KEY (region_code)
REFERENCES region (region_code) ON UPDATE CASCADE ON DELETE SET null;

--
-- Create table `tour_detail`
--
CREATE TABLE tour_detail (
  tp_id int NOT NULL AUTO_INCREMENT,
  tour_id int NOT NULL,
  place_id int NOT NULL,
  create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (tp_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 24,
AVG_ROW_LENGTH = 712;



--
-- Create foreign key
--
ALTER TABLE tour_detail
ADD CONSTRAINT fk_Tour_Place_Place FOREIGN KEY (place_id)
REFERENCES place (place_id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Create foreign key
--
ALTER TABLE tour_detail
ADD CONSTRAINT fk_Tour_Place_Tour FOREIGN KEY (tour_id)
REFERENCES tour (tour_id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Create table `customer`
--
CREATE TABLE customer (
  customer_id int NOT NULL,
  customer_name varchar(100) NOT NULL DEFAULT 'abc',
  tel varchar(100) DEFAULT NULL,
  birthday date DEFAULT NULL,
  email text DEFAULT NULL,
  create_at datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (customer_id)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 3276;



--
-- Create table `booking`
--
CREATE TABLE booking (
  booking_id int NOT NULL AUTO_INCREMENT,
  tour_id int NOT NULL,
  customer_id int NOT NULL,
  customer_number int NOT NULL DEFAULT 1,
  total_cost decimal(20, 4) NOT NULL DEFAULT 0.0000,
  create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (booking_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 5,
AVG_ROW_LENGTH = 4096;



--
-- Create foreign key
--
ALTER TABLE booking
ADD CONSTRAINT fk_Booking_Customer FOREIGN KEY (customer_id)
REFERENCES customer (customer_id) ON UPDATE CASCADE ON DELETE CASCADE;

--
-- Create foreign key
--
ALTER TABLE booking
ADD CONSTRAINT fk_Booking_Tour FOREIGN KEY (tour_id)
REFERENCES tour (tour_id) ON UPDATE CASCADE ON DELETE CASCADE;

--
-- Create table `permission`
--
CREATE TABLE permission (
  per_id int NOT NULL AUTO_INCREMENT,
  per_name varchar(100) DEFAULT NULL,
  per_code varchar(100) NOT NULL,
  PRIMARY KEY (per_id, per_code)
)
ENGINE = INNODB,
AUTO_INCREMENT = 11,
AVG_ROW_LENGTH = 4096;



--
-- Create table `role_permission`
--
CREATE TABLE role_permission (
  rp_id int NOT NULL AUTO_INCREMENT,
  role_id int DEFAULT NULL,
  per_id int DEFAULT NULL,
  PRIMARY KEY (rp_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 25,
AVG_ROW_LENGTH = 2730;



--
-- Create foreign key
--
ALTER TABLE role_permission
ADD CONSTRAINT fk_RP_Per FOREIGN KEY (per_id)
REFERENCES permission (per_id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Create foreign key
--
ALTER TABLE role_permission
ADD CONSTRAINT fk_RP_Role FOREIGN KEY (role_id)
REFERENCES role (role_id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Create table `service`
--
CREATE TABLE service (
  service_id int NOT NULL AUTO_INCREMENT,
  service_name varchar(100) NOT NULL DEFAULT '',
  service_price decimal(20, 4) NOT NULL,
  PRIMARY KEY (service_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 6,
AVG_ROW_LENGTH = 3276;



--
-- Create table `booking_detail`
--
CREATE TABLE booking_detail (
  bd_id int NOT NULL AUTO_INCREMENT,
  booking_id int NOT NULL,
  service_id int NOT NULL,
  PRIMARY KEY (bd_id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 7,
AVG_ROW_LENGTH = 2730;



--
-- Create foreign key
--
ALTER TABLE booking_detail
ADD CONSTRAINT fk_bd_Booking FOREIGN KEY (booking_id)
REFERENCES booking (booking_id) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Create foreign key
--
ALTER TABLE booking_detail
ADD CONSTRAINT fk_bd_service FOREIGN KEY (service_id)
REFERENCES service (service_id) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Dumping data for table role
--
INSERT INTO role VALUES
(1, 'admin'),
(2, 'nhân viên quản lý khách hàng'),
(3, 'nhân viên kế toán'),
(4, 'nhân viên quản lý tour');

-- 
-- Dumping data for table user
--
INSERT INTO user VALUES
(1, 'admin', '123', 'admin', '0908133761', '0000-00-00', 'nam', 1, '2023-04-13 10:26:16'),
(2, 'manager1', '123', 'nhân viên quản lý khách hàng', '0908133761', '0000-00-00', 'nữ', 2, '2023-04-13 10:26:16'),
(3, 'manager2', '123', 'nhân viên kế toán', '0908133761', '0000-00-00', 'nữ', 3, '2023-04-13 10:26:16'),
(4, 'manager3', '123', 'nhân viên quản lý tour', '0908133761', '0000-00-00', 'nam', 4, '2023-04-13 10:26:16');

-- 
-- Dumping data for table hotel
--
INSERT INTO hotel VALUES
(1, 'Thịnh Vượng', '11/2/3 Trần hưng đạo p12, quận10',  '0908133761', 'https://thinhvuong.vn/', 4),
(2, 'Đâu cũng được', '11/2/4 tran bui duong p12, quận5',  '0908133761', 'https://daucungduoc.vn/', 3),
(3, 'Mường Thanh Luxury', 'Nguyễn Văn Trỗi Quận Phú Nhuận',  '0908133761', 'https://muongthanhluxury.vn/', 3),
(4, 'Silverland Jolie Hotel&spa', 'Thi Sách Quận 1',  '0908133761', 'https://silverland.vn/', 5),
(5, 'New Word', 'Lê Lai, Quận 1',  '0908133761', 'https://newword.vn/', 3),
(6, 'Equatorial', 'Trần Bình Trọng Quận 5',  '0908133761', 'https://Equatorial.vn/', 1),
(7, 'Lâu Đài Tính Ái', '11/2/4 tran bui duong p12 quận5',  '0908133761', 'https://laudaitinhai.vn/', 5),
(8, 'Khách Sạn Hoàng Hôn', 'Sơn La',  '0908133761', 'https://hoanghon.vn/', 5),
(9, 'Khách Sạn Gold', 'Bình Dương',  '0908133761', 'https://gold.vn/', 4),
(10, 'Khách Sạn Lucky', 'Quảng Bình',  '0908133761', 'https://lucky.vn/', 5),
(11, 'Resort Diamond', 'Đồng Nai',  '0908133761', 'https://diamond.vn/', 2),
(12, 'Khách Sạn SunGroup', 'Lâm Đồng',  '0908133761', 'https://sungroup.vn/', 3);

-- 
-- Dumping data for table region
--
INSERT INTO region VALUES
(5, 'dalat'),
(1, 'hue'),
(2, 'nhatrang'),
(4, 'phuquoc'),
(3, 'quangninh');

-- 
-- Dumping data for table customer
--
INSERT INTO customer VALUES
(1, 'Nguyễn Thị lé',  '0908133761', '0000-00-00', 'abc@gmai.com', '2023-04-14 00:15:54'),
(2, 'Nguyễn Thị lé1',  '0908133761', '0000-00-00', 'ab1c@gmai.com', '2023-04-14 00:15:54'),
(3, 'Nguyễn Thị lé2',  '0908133761', '0000-00-00', 'abc2@gmai.com', '2023-04-14 00:15:54'),
(4, 'Nguyễn Thị lé3',  '0908133761', '0000-00-00', 'ab3c@gmai.com', '2023-04-14 00:15:54'),
(5, 'Nguyễn Thị lé4',  '0908133761', '0000-00-00', 'abc4@gmai.com', '2023-04-14 00:15:54');

-- 
-- Dumping data for table tour
--
INSERT INTO tour VALUES
(1, 'Du lịch huế',  1, 'hue',500000.0000, '2023-05-13', '2023-05-23', 'Hồ Chí Minh', 'abc', '2023-04-13 10:27:09'),
(2, 'Du lịch đà lạt', 1,'dalat', 500000.0000, '2023-05-13', '2023-05-23', 'Hồ Chí Minh', 'abc', '2023-04-13 10:27:09'),
(3, 'Du lịch nha trang', 1,'nhatrang', 500000.0000, '2023-05-13', '2023-05-23', 'Hồ Chí Minh', 'abc', '2023-04-13 10:27:09'),
(4, 'Du lịch hạ long',  1,'quangninh', 500000.0000, '2023-05-13', '2023-05-23', 'Hồ Chí Minh', 'abc', '2023-04-13 10:27:09'),
(5, 'Du lịch phú quốc', 1,'phuquoc', 500000.0000, '2023-05-13', '2023-05-23', 'Hồ Chí Minh', 'abc', '2023-04-13 10:27:09');

-- 
-- Dumping data for table place
--
INSERT INTO place VALUES
(1, 'Đại Nội Huế', 'Nhắc đến quần thể di tích cố đô Huế, bạn không thể bỏ qua Đại Nội, \r\nmột dấu ấn văn hóa lịch sử độc đáo thuộc quần thể di tích cố đô Huế. Đại Nội là khu vực bao gồm Hoàng Thành và Tử Cấm Thành\r\n với hơn 100 công trình kiến trúc được xây dựng từ thời vua nhà Nguyễn, chứng kiến bao thăng trầm của các triều đại phong kiến V\r\n iệt Nam, và đã được tổ chức UNESCO công nhận là di sản văn hóa thế giới gần 30 năm trước.', 'Thành phố Huế, tỉnh Thừa Thiên Huế','hue','Cong-Ngo-Mon-e1502361090463.png'),
(2, 'Lăng Tự Đức', 'Huế nổi tiếng với các công trình lăng tẩm vua chúa và điện miếu thờ quan thần nhà Nguyễn, mà tiêu biểu nhất trong số đó là lăng Tự Đức – Khiêm Lăng, nơi có phong cảnh sơn thủy hữu tình tuyệt đẹp. Tổng thể công trình lăng Tự Đức mang màu lãng mạn nhưng u tịch, được xây theo nguyện vọng của ông trước khi mất, phảng phất tính cách trầm buồn bởi cuộc đời ông nhiều bất hạnh.', 'Thôn Thượng 3, phường Thủy Xuân, thành phố Huế, tỉnh Thừa Thiên Huế\r\n', 'hue','Khamphahue_LangTamHue_LangVuaTuDuc-daidien.jpg'),
(3, 'Lăng Minh Mạng', 'Lăng Minh Mạng, hay còn gọi là Hiếu Lăng, là nơi chôn cất vị vua có nhiều đóng góp nhiều nhất đối với việc phát\r\n triển và đưa nước Việt vào hãng ngũ các quốc gia lớn nhất Đông Nam Á lúc bấy giờ. ', ' Xã Hương Thọ, huyện Hương Trà, TP. Huế tỉnh Thừa Thiên Huế', 'hue','lang-minh-mang-e1503901472804.jpg'),
(4, 'Sông Hương', 'Mỗi thành phố đều có một dòng sông gắn liền như linh hồn của nơi đó.  cũng vậy. Đây là dòng sông đã đi vào lịch sử, thi ca, đi vào lòng mỗi người dân Huế. Với chiều dài khoảng 80km,  chảy qua rất nhiều địa điểm nổi tiếng của trung tâm thành phố Huế, bao lấy quần thể di tích cố đô, làm tăng thêm vẻ đẹp uy nghiêm, cổ kính của các công trình ấy.', 'Thành phố Huế, tỉnh Thừa Thiên Huế', 'hue','song-huong-Hue-1_1624501838.jpg'),
(5, 'Phố Đi Bộ Huế', 'Phố đi bộ là một địa điểm không thể thiếu ở bất kỳ thành phố du lịch nào. Ở Huế, địa điểm vui chơi về đêm này mới hoạt động thôi, nhưng đã thu hút sự quan tâm của dân địa phương lẫn du khách, đặc biệt là các bạn trẻ.', 'Đường Phạm Ngũ Lão, Chu Văn An và Võ Thị Sáu, phường Phú Hội, thành phố Huế, tỉnh Thừa Thiên Huế  ', 'hue','pho-di-bo-hue-e1515338934239.jpg'),
(6, 'Nhà Thờ Phủ Cam ', 'Tọa lạc trên đồi Phước Quả, nhà thờ Chính tòa Phủ Cam là công trình có từ thời chúa Nguyễn, khi ấy được dựng bằng tranh tre. Trải qua hàng trăm năm và nhiều lần xây dựng, nhà thờ Phủ Cam mới được hoàn thiện như ngày nay.', '1 Đoàn Hữu Trung, phường Phước Vĩnh, thành phố Huế, tỉnh Thừa Thiên Huế', 'hue','nha-tho-phu-cam-0_1633013032.webp'),
(7, 'Thác Datanla Đà Lạt', 'Nếu bạn đang tìm một thác nước đẹp nằm ngay trong thành phố thì hãy đến ngay thác Datanla, nơi có hệ thống máng trượt băng rừng dài nhất Đông Nam Á cùng các trò chơi hấp dẫn khác. Thác Datanla nằm giữa đèo Prenn, có độ cao hơn 20m, lại nằm ở thượng nguồn của dòng chảy nên dòng nước lúc nào cũng chảy ổn định và êm đềm. ', 'Quốc lộ 20, đèo Prenn, phường 3, thành phố Đà Lạt, tỉnh Lâm Đồng', 'dalat','Thác_Datanla.jpg'),
(8, 'Núi Langbiang Đà Lạt', 'Được ví như trái tim của Đà Lạt, núi Langbiang nổi tiếng với loại hình dã ngoại, khám phá thiên nhiên, thu hút các bạn trẻ mê phượt và những nhà mạo hiểm. Nơi đây là ngôi nhà chung của nhiều loại thảo dược, thảo mộc, và chim quý.', 'Thị trấn Lạc Dương, huyện Lạc Dương, tỉnh Lâm Đồng', 'dalat','20220527142859khu-du-lich-lang-biang-da-lat.jpg'),
(9, 'Đồi Robin Đà Lạt', 'Nằm trên đèo Prenn thơ mộng, đồi Robin đã trở thành một điểm tham quan hấp dẫn bởi nơi đây sở hữu tầm nhìn vô cùng thoáng đãng để chiêm ngưỡng vẻ đẹp của Đà Lạt.', '1 Đống Đa, phường 3, thành phố Đà Lạt, tỉnh Lâm Đồng', 'dalat','doi-robin-khu-du-lich-cap-treo-lam-dong-3.jpg'),
(10, 'QUE Garden Đà Lạt', 'Nếu yêu thích nghệ thuật cây cảnh bonsai, hãy ghé đến QUE Garden Đà Lạt, vườn bonsai lá kim lớn nhất Việt Nam. Đến , bạn ngỡ như mình đang ở đất nước mặt trời mọc, với những chậu cây bonsai được chăm sóc và uốn nắn kỹ lưỡng vô cùng đẹp mắt, bên cạnh hồ cá Koi đạt tiêu chuẩn Nhật Bản với hàng ngàn con cá Koi to khỏe. ', 'Phường 10, thành phố Đà Lạt, tỉnh Lâm Đồng', 'dalat','heqebquzmhjgtsapkfc2.webp'),
(11, 'Thác Pongour Đà Lạt', ' được rất nhiều người biết đến bởi sự hùng vĩ, hoang sơ với hệ động thực vật đa dạng và được mệnh danh là Nam Thiên Đệ Nhất Thác', 'Thôn Tân Nghĩa, xã Ninh Gia, huyện Đức Trọng, tỉnh Lâm Đồng', 'dalat','thac-pongour-1_1689673738.jpg'),
(12, 'Chợ Đêm Đà Lạt', 'Từ lâu, chợ đêm Đà Lạt đã thành điểm đến quen thuộc mà bất cứ ai khi đến du lịch Đà Lạt đều muốn lui tới. Chợ đêm Đà Lạt, hay còn được gọi là chợ Âm Phủ, tọa lạc ngay trung tâm thành phố, rất gần các bến xe khách và quảng trường thành phố. Chợ đêm nhộn nhịp cả trong nhà lẫn ngoài trời nên rất tiện lợi cho bạn ghé qua.', 'Đường Nguyễn Thị Minh Khai, phường 1, thành phố Đà Lạt, tỉnh Lâm Đồng', 'dalat','cap-nhat-cho-dem-da-lat-o-duong-nao-co-gi-thu-vi-5f3aafca8812e.jpg'),
(13, 'Bảo tàng Quảng Ninh', 'Bảo tàng – thư viện Quảng Ninh được ví như viên ngọc đen quý báu, sáng lấp lánh bên vịnh Hạ Long. Với thiết kế phá cách, đơn giản mà sang trọng, tòa nhà vuông vức với toàn bộ bề mặt bên ngoài màu đen đã thu hút rất đông du khách du lịch Hạ Long tới tham quan, chụp ảnh. ', '', 'quangninh','bao tang lsu quan doi.jpg'),
(14, 'Vịnh Hạ Long', 'Với vẻ đẹp non nước hùng vĩ tựa tranh vẽ, vịnh Hạ Long được UNESCO công nhận là kỳ quan thiên nhiên thế giới. Sự hiện diện của hàng nghìn hòn đảo và hang động hoang sơ, đẹp kỳ bí cùng hệ sinh thái phong phú, vịnh Hạ Long đã trở thành điểm đến cực kỳ độc đáo mà bất kỳ du khách nào cũng muốn ghé thăm. Một hòn đảo, hang động nổi tiếng tại vịnh Hạ Long bạn có thể tham khảo như: hòn Gà Chọi, đảo Ngọc Vừng, hòn Con Cóc, đảo Ti Tốp, hang Sửng Sốt...', '', 'quangninh','kinh-nghiem-du-lich-vinh-ha-long-1.webp'),
(15, 'Du lịch đảo Tuần Châu, Hạ Long', NULL, '', 'quangninh','download.jpeg'),
(16, 'Vinpearl Land', NULL, '98B/13, Trần Phú, Lộc Thọ, Thành phố Nha Trang, Khánh Hòa', 'nhatrang','vinpeart_land.png'),
(17, 'Viện Hải dương học', NULL, 'số 1, Cầu Đá, Trần Phú, thành phố Nha Trang, tỉnh Khánh Hòa.', 'nhatrang','vien-hai-duong-hoc-nha-trang-2.webp'),
(18, 'Đảo Điệp Sơn', 'Nằm trong Vịnh Ninh Vân xinh đẹp, đảo Điệp Sơn đẹp nổi bật như một dấu ấn riêng của Nha Trang', '', 'nhatrang','dao-diep-son_1627977948.jpg'),
(19, 'Đảo Khỉ Nha Trang', 'Nha Trang gây ấn tượng với du khách với nhiều địa điểm du lịch thú vị và độc đáo, trong đó có Đảo Khỉ Nha Trang.', '', 'nhatrang','khi-an-trai-cay.jpg'),
(20, 'Grand World Phú Quốc - Khám phá \"Thành phố không ngủ\"', 'Grand World Phú Quốc nằm trong quần thể nghỉ dưỡng, giải trí đẳng cấp hàng đầu tại Việt Nam - Phú Quốc United Center. Tổ hợp vui chơi, mua sắm, giải trí này thuộc địa phận bãi Dài, xã Gành Dầu, Phú Quốc, Kiên Giang. ', '', 'phuquoc','121101678_672984973348701_1338295634941350714_o.jpg'),
(21, 'VinWonders Phú Quốc - Thiên đường vui chơi giải trí', 'Grand World Phú Quốc nằm trong quần thể nghỉ dưỡng, giải trí đẳng cấp hàng đầu tại Việt Nam - Phú Quốc United Center. Tổ hợp vui chơi, mua sắm, giải trí này thuộc địa phận bãi Dài, xã Gành Dầu, Phú Quốc, Kiên Giang. ', '', 'phuquoc','Vé VinWonders Phú Quốc.jpg'),
(22, 'Hòn Đồi Mồi ', 'Mệnh danh là hòn đảo có nhiều sinh vật phong phú nhất Phú Quốc, hòn Đồi Mồi sẽ đưa bạn đến gần với thiên nhiên hoang sơ đầy kỳ bí. Hòn Đồi Mồi cách Bãi Dài chỉ khoảng 1km. Đây là địa điểm du lịch Phú Quốc lý tưởng để tổ chức những bữa tiệc BBQ trên bãi biển, những hoạt động vui chơi, teambuilding cực kỳ thú vị với bạn bè, người thân. ', '', 'phuquoc','hon-doi-moi-2.jpeg'),
(23, 'Bãi Sao - Bãi biển đẹp nhất Phú Quốc', 'Bãi Sao được ôm trọn bởi 2 dãy núi chạy sát biển nên có khí hậu trong lành, mát mẻ cực kỳ thích hợp cho một kỳ nghỉ dưỡng tuyệt vời mỗi khi hè về. Khoảng thời gian du lịch đẹp nhất của bãi Sao từ tháng 6 đến tháng 10 hằng năm. ', '', 'phuquoc','bai-sao-phu-quoc-02_1655376681.jpg');

-- 
-- Dumping data for table permission
--
INSERT INTO permission VALUES
(1, 'tài khoản (tất cả tài khoản)', 'account'),
(2, 'khách hàng (chỉ mỗi khách hàng)', 'customer'),
(3, 'hoá đơn(booking)', 'booking'),
(4, 'tour', 'tour'),
(5, 'service', 'service'),
(6, 'địa điểm du lịch', 'place'),
(7, 'khách sạn', 'hotel'),
(8, 'thống kê/báo cáo', 'statistical/report'),
(9, 'nhập/xuất dữ liệu (excel)', 'excel');

-- 
-- Dumping data for table service
--
INSERT INTO service VALUES
(1, 'Nhà hàng 5 sao - bữa ăn hải sản', 800000.0000),
(2, 'mua sắm giảm 30% - tặng kèm nhiều dịch vụ miễn phí', 300000.0000),
(3, 'tự do, miễn phí chơi ở khu thể thao', 100000.0000),
(4, 'miễn phí khi chơi ở các khu vui chơi giải trí', 200000.0000),
(5, 'đi kèm các dụng cụ du lịch thiết yếu, giúp tăng trải nghiệm du lịch', 300000.0000);

-- 
-- Dumping data for table booking
--
INSERT INTO booking VALUES
(1, 1, 1, 1, 800000.0000, '2023-04-14 00:15:54'),
(2, 1, 2, 1, 1100000.0000, '2023-04-14 00:15:54'),
(3, 2, 3, 2, 1300000.0000, '2023-04-14 00:15:54'),
(4, 2, 4, 1, 1100000.0000, '2023-04-14 00:15:54');

-- 
-- Dumping data for table tour_detail
--
INSERT INTO tour_detail(tour_id,place_id,create_at) VALUES
( 1, 1, '2023-04-13 10:28:31'),
( 1, 2, '2023-04-13 10:28:31'),
( 1, 3, '2023-04-13 10:28:31'),
( 1, 4, '2023-04-13 10:28:31'),
( 1, 5, '2023-04-13 10:28:31'),
( 1, 6, '2023-04-13 10:28:31'),
( 2, 7, '2023-04-13 10:28:31'),
( 2, 8, '2023-04-13 10:28:31'),
( 2, 9, '2023-04-13 10:28:31'),
( 2, 10, '2023-04-13 10:28:31'),
( 2,11, '2023-04-13 10:28:31'),
( 2, 12, '2023-04-13 10:28:31'),


( 3, 16, '2023-04-13 10:28:31'),
( 3, 17, '2023-04-13 10:28:31'),
( 3, 18, '2023-04-13 10:28:31'),
( 3, 19, '2023-04-13 10:28:31'),
( 4, 13, '2023-04-13 10:28:31'),
( 4, 14, '2023-04-13 10:28:31'),
( 4, 15, '2023-04-13 10:28:31'),
( 5, 20, '2023-04-13 10:28:31'),
( 5, 21, '2023-04-13 10:28:31'),
( 5, 22, '2023-04-13 10:28:31'),
( 5, 23, '2023-04-13 10:28:31');




-- 
-- Dumping data for table role_permission
--
INSERT INTO role_permission VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(11, 2, 2),
(12, 2, 3),
(14, 2, 5),
(17, 3, 8),
(18, 3, 9),
(19, 4, 4),
(20, 4, 6),
(21, 4, 7);

-- 
-- Dumping data for table booking_detail
--
INSERT INTO booking_detail VALUES
(1, 1, 5),
(2, 2, 2),
(3, 2, 5),
(4, 3, 5),
(5, 4, 2),
(6, 4, 5);



