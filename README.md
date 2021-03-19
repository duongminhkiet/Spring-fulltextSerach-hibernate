# Spring-fulltextSerach-hibernate


Đây là prj demo về fulltext search sử dụng hibernate, mặc dù cũng là 1 tính năng ok nhưng chưa tối ưu cho các dạng như tiếng việt,
muốn dùng cho tiếng việt tốt chỉ có cách nhanh nhất là lưu cả tiếng việt có dấu và tiếng việt không dấu. Nếu không chỉ còn 2 cách khác: 
1. Sử dụng các công nghệ tối ưu khác như Elasticsearch, Solr, ... làm server riêng (kể cả mongodb).
2. Tìm hiểu thêm về analyze trong phần hibernate