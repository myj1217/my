import React from "react";
import logo from "./img/logo.png";
import facebook from "./img/btn_facebook.png";
import tstory from "./img/btn_tstory.png";
import mbmenu from "./img/btn_mobile_menu.png";
import mbsearch from "./img/btn_mobile_search.png";
import mblogin from "./img/btn_mobile_login.png";

const Header = () => {
  return (
    <div className="all_menu">
      <div className="pc_menu">
        <div className="top_menu menu_a">
          <ul>
            <li>
              <a href=" ">홈</a>
            </li>
            <li>
              <a href=" ">로그인</a>
            </li>
            <li>
              <a href=" ">회원가입</a>
            </li>
            <li>
              <a href=" ">사이트맵</a>
            </li>
            <li>
              <a href=" ">성북문화재단</a>
            </li>
          </ul>
        </div>
        <div className="mid_menu">
          <div className="logo">
            <a href=" ">
              <img src={logo} alt="logo" />
            </a>
          </div>
          <div className="search_box">
            <input type="text" placeholder="검색어 입력" name="search" />
          </div>
          <div className="search_btn">
            <a href=" ">검색</a>
          </div>
          <div className="icon">
            <a href=" ">
              <img src={facebook} alt="facebook" />
            </a>
            <a href=" ">
              <img src={tstory} alt="tstory" />
            </a>
          </div>
        </div>
        <div className="bot_menu menu_a">
          <ul>
            <li>
              <a href=" ">책읽는성북</a>
            </li>
            <li>
              <a href=" ">자료검색</a>
            </li>
            <li>
              <a href=" ">도서관 소개</a>
            </li>
            <li>
              <a href=" ">도서관 이용</a>
            </li>
            <li>
              <a href=" ">정보마당</a>
            </li>
          </ul>
        </div>
      </div>
      <div className="mb_menu">
        <div className="mb_left">
          <a href=" ">
            <img src={mbmenu} alt="mb_menu" />
          </a>
        </div>
        <div className="mb_center">
          <a href=" ">
            <img src={logo} alt="mb_logo" />
          </a>
        </div>
        <div className="mb_right">
          <a href=" ">
            <img src={mbsearch} alt="mb_search" />
          </a>
          <a href=" ">
            <img src={mblogin} alt="mb_login" />
          </a>
        </div>
      </div>
    </div>
  );
};

export default Header;
