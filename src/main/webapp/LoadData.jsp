<%@page import="com.mycompany.smartparkingmanagement.entities.Week"%>
<%@page import="com.mycompany.smartparkingmanagement.dao.DashBoardDao"%>
<%@page import="java.util.ArrayList"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js" integrity="sha512-Wt1bJGtlnMtGP0dqNFH1xlkLBNpEodaiQ8ZN5JLA5wpc1sUlk/O5uuOMNgvzddzkpvZ9GLyYNa8w2s7rqiTk5Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<%
    DashBoardDao dao = new DashBoardDao();
    Week list = dao.traffic();
%>
<style>
    .chartBox{
        width: 500px;
        height: 400px;
    }
</style>
<div class="chartBox">
    <canvas id="myChart" width="400" height="400"></canvas>
</div>



<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var sunday = "<%= list.getSunday()%>";
    var monday = "<%= list.getMonday()%>";
    var tuesday = "<%= list.getTuesday()%>";
    var wednesday = "<%= list.getWednesday()%>";
    var thursday = "<%= list.getThursday()%>";
    var friday = "<%= list.getFriday()%>";
    var saturday = "<%= list.getSaturday()%>";
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
            datasets: [{
                    label: "Total Count of Bookings",
                    data: [sunday, monday, tuesday, wednesday, thursday, friday, saturday],
                    backgroundColor: [
                        'rgba(8, 17, 23, 0.2)',
                        'rgba(8, 17, 23, 0.2)',
                        'rgba(8, 17, 23, 0.2)',
                        'rgba(8, 17, 23, 0.2)',
                        'rgba(8, 17, 23, 0.2)',
                        'rgba(8, 17, 23, 0.2)',
                        'rgba(8, 17, 23, 0.2)',
                    ],
                    borderColor: [
                        'rgba(8, 17, 23, 1)',
                        'rgba(8, 17, 23, 1)',
                        'rgba(8, 17, 23, 1)',
                        'rgba(8, 17, 23, 1)',
                        'rgba(8, 17, 23, 1)',
                        'rgba(8, 17, 23, 1)',
                        'rgba(8, 17, 23, 1)',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            maintainAspectRatio: false,
            scales: {
                y: {
                    beginAtZero: true,
                    grid: {display: false}
                }
            }
        }
    });</script>
<script>
    window.setInterval('refresh()', 10000); // Call a function every 10000 milliseconds (OR 10 seconds).
// Refresh or reload page.
    function refresh() {
        window.location.reload();
    }
</script>