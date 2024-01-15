import React from "react";

const Blanket = ({ data }) => {
  const {
    bookname,
    authors,
    bookDtlUrl,
    bookImageURL,
    publisher,
    isbn13,
    publication_year,
  } = data;

  return (
    <div>
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
      </div>
    </div>
  );
};

export default Blanket;
