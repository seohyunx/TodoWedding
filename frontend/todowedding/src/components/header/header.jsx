import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import TodoLogo from "../../assets/images/todo_logo.png";
import { AiOutlineRadiusSetting } from "react-icons/ai";
import { GiHamburgerMenu } from "react-icons/gi";

/*
 * Header
 * 작성자 : 서현록
 * 작성일 : 2023.09.04
 */

/*
 * 카카오 로그인 후 닉네임 적용 , 로그아웃 세션삭제 및 메인페이지경로수정
 * 작성자 : 양수진
 * 작성일 : 2023.09.08
 */
 
const style = {
    button: `border p-2 ml-2 bg-purple-500 text-slate-100`,
};

const Header = () => {
    const [kakaoUserNick, setKakaoUserNick] = useState(""); // 로그인된 닉네임 상태

    useEffect(() => {
        //카카오 로그인 정보 가져오기 - 헤더에서 따서 쓰기
        const KakaoUserSeq = sessionStorage.getItem("KakaoUserSeq");
        const KakaoUserNick = sessionStorage.getItem("KakaoUserNick");

        // 카카오 로그인 정보가 있는 경우에만 닉네임 상태값 업데이트
        if (KakaoUserSeq && KakaoUserNick) {
            setKakaoUserNick(KakaoUserNick);
        }
    }, []);

    return (
        <div className="header-bar">
            <img
                src={TodoLogo}
                alt="ToDo"
                width="90px"
                onClick={() => {
                    window.location.href = "/";
                }}
                style={{ cursor: "pointer" }}
            />

            <div>
                <div className="welcome-nick">
                    {kakaoUserNick ? ( // kakaoUserNick 값이 존재하면 로그인된 닉네임으로 표시
                        <p className="text-sj">
                            {" "}
                            {kakaoUserNick}님 환영합니다
                            <Link to="/todowedding/login" id="login-btn">
                                <button className={style.button}>{<GiHamburgerMenu />}</button>
                            </Link>
                        </p>
                    ) : (
                        <a href="/todowedding/login" className="main-login">
                            <span className="text-sm">로그인</span>
                        </a>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Header;
