import { useCallback, useState } from "react";

// 입력을 할 때 입력을 강제로 할때 = event
const BlktInsert = ({ onInsert }) => {
  const [value, setValue] = useState("");
  // 초기값은 비어져있는 공백
  const onChange = useCallback((e) => {
    setValue(e.target.value);
    // 재사용하기 때문에 callback 함수로 감쌌음
    // 같은 내용 리렌더링 하지 않음 -> 엄청난 최적화로 이어짐
  }, []);
  const onSubmit = useCallback(
    (e) => {
      onInsert(value);
      setValue(""); // value를 받고 초기화
      e.preventDefault();
      // 기본동작 취소
      // 원래 초기화하는 기능이 있는데
      // 기능을 그대로두면 우리가 입력한 값이
      // 등록이 안되고 초기화가 되므로
      // 억제시켜놔야함
    },
    [onInsert, value]
    // 변경이 있으면 다시 읽어들여라
  );
  return (
    <NewsItemBlock>
      <div className="index">
        <p>{index + 1}</p>
      </div>
      {bookImageURL && (
        <div className="thumbnail">
          <a href={bookDtlUrl} target="_blank" rel="noopener noreferrer">
            <img src={bookImageURL} alt="thumbnail" />
          </a>
        </div>
      )}
      <div className="contents">
        <h2>
          <a href={bookDtlUrl} target="_blank" rel="noopener noreferrer">
            {bookname}
          </a>
        </h2>
        <p>{authors}</p>
        <p>
          출판: {publisher}, {publication_year}
        </p>
        <p>ISBN: {isbn13}</p>
        <button onClick={() => onInsert()}>대출하기</button>
      </div>
      {/* <Blanket data={data} /> */}
    </NewsItemBlock>
  );
};

export default BlktInsert;
