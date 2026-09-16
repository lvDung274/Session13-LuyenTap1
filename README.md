1.Vì sao dùng for-each để xóa phần tử lại gây lỗi?
sử dụng vòng lặp for-each (for (Product p : cart)), Java thực chất đang ngầm sử dụng một Iterator bên dưới để duyệt qua từng phần tử của danh sách.

Cơ chế Fail-Fast: Danh sách (List) duy trì một biến đếm số lần thay đổi cấu trúc (modCount). Khi vòng lặp chạy, Iterator liên tục kiểm tra biến đếm này.

Lỗi xảy ra: Khi gọi trực tiếp cart.remove(p) từ bên ngoài trong lúc vòng lặp đang chạy, danh sách hiểu rằng cấu trúc đã bị thay đổi, 
nhưng Iterator không hề hay biết về sự thay đổi trực tiếp này. Ngay ở lần lặp tiếp theo, Iterator phát hiện sự bất đồng bộ và lập tức quăng
ngoại lệ ConcurrentModificationException (Lỗi sửa đổi đồng thời) để ngăn chặn việc dữ liệu bị hỏng.
