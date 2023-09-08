<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Geolocation Example</title>
    <!-- Naver Maps API 스크립트 추가 -->
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=5vx586o8ep&submodules=geocoder"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</head>
<body>
    <button onclick="getLocation()">Get Location</button>
    <script>
        function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(function(position) {
                    var latitude = position.coords.latitude;
                    var longitude = position.coords.longitude;
                    var latlng = new naver.maps.LatLng(latitude, longitude);
                    searchCoordinateToAddress(latlng);
                });
            } else {
                alert("Geolocation is not supported by this browser.");
            }
        }

        function searchCoordinateToAddress(latlng) {
            naver.maps.Service.reverseGeocode({
                coords: latlng,
                orders: [
                    naver.maps.Service.OrderType.ADDR,
                    naver.maps.Service.OrderType.ROAD_ADDR
                ].join(',')
            }, function(status, response) {
                if (status === naver.maps.Service.Status.ERROR) {
                    return alert('Something Wrong!');
                }

                var items = response.v2.results;

                if (items.length > 0) {
                    var item = items[0];
                    var address = makeAddress(item) || '';

                    // 서버로 주소 정보 전송
                    sendAddressToServer(address);
                }
            });
        }

        function sendAddressToServer(address) {
            // AJAX를 통한 서버로의 요청
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/user/location", true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    console.log("Address sent to server successfully.");
                }
            };

            var data = JSON.stringify({ address: address });
            xhr.send(data);
        }
    </script>
</body>
</html>
