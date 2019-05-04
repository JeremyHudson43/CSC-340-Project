# CSC-340-Project

Please clone the src folder under the master branch to your local machine, relevant .jar files are in libManage under src. Our final commit with all java classes was performed under this src folder. 

Also the check-in and checkout functions will not work unless this SQL patch is applied to the server. 

use library;
alter table checkout
add column status varchar(20) after checkoutDate;
