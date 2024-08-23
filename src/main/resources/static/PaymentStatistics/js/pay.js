/*document.addEventListener('DOMContentLoaded', function() {
	var tablenot = document.querySelector('#notbill');
    tablenot.style.display = 'none'; // Ẩn bảng lúc đầu
    var table = document.querySelector('#billpaid');
    table.style.display = 'none';
    
    fetch('/IncomeBill/statistics')
        .then(response => response.json())
        .then(data => {
            var ctx = document.getElementById('donutChart').getContext('2d');
            var myDonutChart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: ['Bill Paid', 'Bill Not Paid'],
                    datasets: [{
                        label: 'Total Amount',
                        data: [data['Bill Paid'], data['Bill Not Paid']],
                        backgroundColor: ['#36A2EB', '#FF6384']
                    }]
                },
                options: {
                    responsive: true,
                    onClick: function(event, elements) {
                        if (elements.length > 0) {
                            var clickedIndex = elements[0].index;
                            var label = myDonutChart.data.labels[clickedIndex];

							if (label === 'Bill Not Paid') {
								tablenot.style.display = 'table';
								table.style.display = 'none';
								}else {
                                table.style.display = 'table';
								tablenot.style.display = 'none'; // Ẩn bảng nếu click vào phần khác
                            }                                                                            
                        }
                    }
                }
                });
                document.getElementById('totalAmount').textContent = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data['Bill Paid']+data['Bill Not Paid']);
        })
        .catch(error => console.error('Error fetching data:', error));
});*/

/*document.addEventListener('DOMContentLoaded', function() {
    var tablenot = document.querySelector('#notbill');
    var table = document.querySelector('#billpaid');

    // Ẩn cả hai bảng lúc đầu
    tablenot.style.display = 'none';
    table.style.display = 'none';

    // Load Google Charts
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        fetch('/IncomeBill/statistics')
            .then(response => response.json())
            .then(data => {
                // Chuẩn bị dữ liệu cho biểu đồ
                var chartData = google.visualization.arrayToDataTable([
                    ['Task', 'Amount'],
                    ['Chưa thanh toán', data['Bill Not Paid']],
                    ['Thanh toán', data['Bill Paid']]
                ]);

                // Thiết lập biểu đồ
                var options = {
                    title: 'Cu Dan',
                    pieHole: 0.4,
                    colors: ['#FF6384', '#36A2EB'], // Màu sắc tương ứng
                    legend: {
                        position: 'bottom'
                    }
                };

                // Tạo biểu đồ
                var chart = new google.visualization.PieChart(document.getElementById('donutchart'));

                // Xử lý sự kiện click trên biểu đồ
                google.visualization.events.addListener(chart, 'select', function() {
                    var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                        var selectedLabel = chartData.getValue(selectedItem.row, 0);

                        if (selectedLabel === 'Chưa thanh toán') {
                            tablenot.style.display = 'table';
                            table.style.display = 'none';
                        } else if (selectedLabel === 'Thanh toán') {
                            table.style.display = 'table';
                            tablenot.style.display = 'none';
                        }
                    }
                });

                // Vẽ biểu đồ với dữ liệu và tùy chọn đã chuẩn bị
                chart.draw(chartData, options);
                document.getElementById('totalAmount').textContent = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(data['Bill Paid']+data['Bill Not Paid']);
            })
            .catch(error => console.error('Error fetching data:', error));
    }
});*/

document.addEventListener('DOMContentLoaded', function() {
    var tablenot = document.querySelector('#notbill');
    var table = document.querySelector('#billpaid');

    // Ẩn cả hai bảng lúc đầu
    tablenot.style.display = 'none';
    table.style.display = 'none';

    // Load Google Charts
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        fetch('/IncomeBill/statistics')
            .then(response => response.json())
            .then(data => {
				 // Thêm tổng tiền vào biểu đồ
                var totalAmount = data['Bill Paid'] + data['Bill Not Paid'];
                var totalText = 'Tổng tiền: ' + new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(totalAmount);
                
                // Chuẩn bị dữ liệu cho biểu đồ
                var chartData = google.visualization.arrayToDataTable([
                    ['Task', 'Amount'],
                    ['Chưa thanh toán', data['Bill Not Paid']],
                    ['Thanh toán', data['Bill Paid']]
                ]);

                // Thiết lập biểu đồ
                var options = {
                    title: 'Cu Dan'+"/b"+totalText,
                    pieHole: 0.4,
                    colors: ['#FF6384', '#36A2EB'], // Màu sắc tương ứng
                    legend: {
                        position: 'bottom'
                    },
                    annotations: {
                        alwaysOutside: true,
                        textStyle: {
                            fontSize: 12,
                            color: '#555',
                            auraColor: 'none'
                        }
                    }
                };

                // Tạo biểu đồ
                var chart = new google.visualization.PieChart(document.getElementById('donutchart'));

                // Xử lý sự kiện click trên biểu đồ
                google.visualization.events.addListener(chart, 'select', function() {
                    var selectedItem = chart.getSelection()[0];
                    if (selectedItem) {
                        var selectedLabel = chartData.getValue(selectedItem.row, 0);

                        if (selectedLabel === 'Chưa thanh toán') {
                            tablenot.style.display = 'table';
                            table.style.display = 'none';
                        } else if (selectedLabel === 'Thanh toán') {
                            table.style.display = 'table';
                            tablenot.style.display = 'none';
                        }
                    }
                });

                // Vẽ biểu đồ với dữ liệu và tùy chọn đã chuẩn bị
                chart.draw(chartData, options);

               
            })
            .catch(error => console.error('Error fetching data:', error));
    }
});