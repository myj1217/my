const PI = 3.141592;

// 원의 넓이
function getArea(radius) {
  return PI * radius * radius;
}

// 원의 둘레
function getCircumference(radius) {
  return 2 * PI * radius;
}

export default { PI, getArea, getCircumference };
