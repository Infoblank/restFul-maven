//鼠标按下且移动时触发，
function move() {

    const body = document.querySelector("body");
    const box = document.querySelector(".box");
    const xNum = document.querySelector(".xNum");
    const yNum = document.querySelector(".yNum");
    const x = 0, y = 0, z = 0;
    let xx = 0, yy = 0;
    let xArr = [], yArr = [];
    window.onmousedown = function (e) {//鼠标按下事件
        body.style.cursor = 'url("images/img.png"),auto';
        xArr[0] = e.clientX / 2;//获取鼠标点击屏幕时的坐标
        yArr[0] = e.clientY / 2;
        window.onmousemove = function (e) {//鼠标移动事件————当鼠标按下且移动时触发
            xArr[1] = e.clientX / 2;//获取鼠标移动时第一个点的坐标
            yArr[1] = e.clientY / 2;
            yy += xArr[1] - xArr[0];//获得鼠标移动的距离
            xx += yArr[1] - yArr[0];
            xNum.value = xx + "°";//将所获得距离数字赋值给input显示旋转角度
            yNum.value = yy + "°";
            //将旋转角度写入transform中
            box.style.transform = "rotatex(" + xx + "deg) rotatey(" + yy + "deg) rotatez(0deg)scale3d(0.7,0.7,0.7)";
            xArr[0] = e.clientX / 2;
            yArr[0] = e.clientY / 2;
        }
    };
    window.onmouseup = function () {//鼠标抬起事件————用于清除鼠标移动事件，
        body.style.cursor = 'url("images/img.png"),auto';
        window.onmousemove = null;
    }
}

//点击事件、负责立方体盒子的六面伸展
function clickBox() {

    const btn = document.querySelector(".open");
    const box = document.querySelector(".box");
    const son = box.children;
    let value = 0;
    //存储立方体散开时的transform参数
    const arr0 = ["rotatey(-90deg) translatex(-100px)", "rotatey(90deg) translatex(100px)", "rotatex(90deg) translatey(-100px)",
        "rotatex(-90deg) translatey(100px)", "translatez(-100px)", "translatez(100px)"];
    //存储立方体合并时的transform参数
    const arr1 = ["rotatey(-90deg) translatex(-100px)translatez(100px)", "rotatey(90deg) translatex(100px)translatez(100px)",
        "rotatex(90deg) translatey(-100px)translatez(100px)", "rotatex(-90deg) translatey(100px)translatez(100px)", "translatez(-200px)", "translatez(200px)"];
    btn.onclick = function () {
        if (value === 0) {
            value = 1;
            btn.value = "点击合并";
            for (let i = 0; i < arr1.length; i++) {
                son[i].style.transform = arr1[i];
                console.log(son[i])
            }
        } else if (value === 1) {
            value = 0;
            btn.value = "点击散开";
            for (let j = 0; j < arr0.length; j++) {
                son[j].style.transform = arr0[j];
                console.log(j);
            }
        }
    }
}
