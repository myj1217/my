import React, { useEffect, useState } from "react";

const { kakao } = window;

const FinalLocation = () => {
  const [location, setLocation] = useState({});
  useEffect(() => {
    navigator.geolocation.getCurrentPosition(
      (position) => {
        setLocation({
          latitude: position.coords.latitude,
          longitude: position.coords.longitude,
        });
      },
      (error) => console.log(error)
    );
    // 지도를 담을 영역의 DOM 래퍼런스
    const container = document.getElementById("map");
    // 지도의 중심좌표
    const options = {
      center: new kakao.maps.LatLng(location.latitude, location.longitude),
      level: 3,
    };
    // 지도 생성 및 객체 리턴
    const map = new kakao.maps.Map(container, options);
    //마커가 표시 될 위치
    let markerPosition = new kakao.maps.LatLng(
      location.latitude,
      location.longitude
    );
    // 마커를 생성
    let marker = new kakao.maps.Marker({
      position: markerPosition,
    });
    // 마커를 지도 위에 표시
    marker.setMap(map);
  }, [{ location }]);

  return <div id="map" style={{ width: "500px", height: "400px" }}></div>;
};

export default FinalLocation;
