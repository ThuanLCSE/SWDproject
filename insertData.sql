

INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('1', 'Ngoc', 'Son Ngoc', '123', '0', '123456', 'admin', '2016/09/09');
INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('2', 'Thuan', 'Minh Thuan', '123', '0', '123456', 'admin', '2016/09/09');
INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('3', 'Quan', 'Ki Quan', '123', '0', '123456', 'admin', '2016/09/09');
INSERT INTO `mydb`.`user` (`userID`, `username`, `fullname`, `profilePictureUrl`, `totalBlog`, `password`, `role`, `createDay`) VALUES ('4', 'Hung', 'Manh Hung', '123', '0', '123456', 'member', '2016/09/09');


INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('1', '2016/09/09', '0', '0', 'ngay xa xam', '123', '0', '2016/09/09', '1');
INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('2', '2016/09/15', '0', '0', 'nho ki niem xua', '123', '1', '2016/10/13', '2');
INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('3', '2016/10/09', '0', '0', 'Hoc tap tot', '135', '0', '2016/10/11', '4');
INSERT INTO `mydb`.`publishedblog` (`blogID`, `PublishedDay`, `numberOfComment`, `numberOfLike`, `content`, `imageUrl`, `Published`, `lastUpdateDay`, `userID`) VALUES ('4', '2016/11/11', '0', '0', 'Ki luat tot', '89', '1', '2016/12/03', '3');


INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('1', 'Thu Vien');
INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('2', 'Truong hoc');
INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('3', 'Lop Hoc');
INSERT INTO `mydb`.`category` (`CategoryID`, `name`) VALUES ('4', 'Thanh pho');
