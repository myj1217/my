import React from "react";

const { kakao } = window;

const LocationList = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(37.6050025, 127.0507423),
    level: 10,
  };
  const map = new kakao.maps.Map(container, options);
  const positions = [
    {
      title: "성북정보도서관",
      latlng: new kakao.maps.LatLng(37.6050025, 127.0507423),
    },
    {
      title: "아리랑도서관",
      latlng: new kakao.maps.LatLng(37.5998924, 127.0139225),
    },
    {
      title: "해오름도서관",
      latlng: new kakao.maps.LatLng(37.5940488, 127.0105522),
    },
    {
      title: "성북길빛도서관",
      latlng: new kakao.maps.LatLng(37.6098358, 127.0263263),
    },
  ];
  const imageSrc =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
  // for
  positions.forEach((el) => {
    // 마커 이미지의 이미지 크기 입니다
    const imageSize = new kakao.maps.Size(24, 35);
    // 마커 이미지를 생성합니다
    const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
    // 마커를 생성합니다
    new kakao.maps.Marker({
      //마커가 표시 될 지도
      map: map,
      //마커가 표시 될 위치
      position: el.latlng,
      //마커에 hover시 나타날 title
      title: el.title,
      // 마커 이미지
      image: markerImage,
    });
  });
  return <div id="map" style={{ width: "100vw", height: "100vh" }}></div>;
};

export default LocationList;
