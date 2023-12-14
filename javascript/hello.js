const myCar = {
    color:'red',
    logColor:function(){
        console.log(this);
        console.log(this.color);
    },
};
myCar.logColor();