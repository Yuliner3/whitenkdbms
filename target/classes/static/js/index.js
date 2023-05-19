//固定导航和返回按钮的时机
const headerEl = document.querySelector("header");
const scrollToTop = document.querySelector(".scrollToTop");

window.addEventListener("scroll", () => {
    let height = headerEl.getBoundingClientRect().height;

    if (window.pageYOffset - height > 800) {
        if (!headerEl.classList.contains("sticky")) {
            headerEl.classList.add("sticky");
        }
    } else {
        headerEl.classList.remove("sticky");
    }


    if (window.pageYOffset > 2000) {
        scrollToTop.style.display = "block";
    } else {
        scrollToTop.style.display = "none";
    }
});


// 定义一个glide，使glide组件会选择div中带有选择器.glide的作为轮播组件
const glide = new Glide(".glide");

const captionsEL = document.querySelectorAll(".slide-caption");
//触发事件
glide.on(["mount.after", "run.after"], () => {
    //mount.after是在轮播时触发，run.after是在视频运行时触发
    const caption = captionsEL[glide.index];
    anime({
        //传递一些配置选项
        targets: caption.children, //对谁执行动画
        opacity: [0, 1],
        duration: 400,//动画执行时间，400ms
        easing: "linear", //动画执行函数,linear:线性的
        delay: anime.stagger(400, {start: 300}), //间隔400ms
        translateY: [anime.stagger([40, 10]), 0]
    });
});

glide.on("run.before", () => {
    document.querySelectorAll(".slide-caption > *").forEach(el => {
        el.style.opacity = 0;
    });
});

glide.mount();//此处方法会使轮播组件下载好

const isotope = new Isotope(".cases", {
    layoutMode: "fitRows",  //行模式布局：每一行都占满后再起下一行
    itemSelector: ".case-item" //定位到具体哪一个案例
});

//获取筛选按钮实例
const filterBtns = document.querySelector(".filter-btns");
filterBtns.addEventListener("click", e => {
    let {target} = e;
    const filterOption = target.getAttribute("data-filter");
    if (filterOption) {
        document.querySelectorAll(".filter-btn.active").forEach(btn => btn.classList.remove("active"));
        target.classList.add("active");

        isotope.arrange({filter: filterOption});
    }
})

// 通用配置项
const staggeringOption = {
    delay: 300,
    distance: "50px",
    duration: 500,
    easing: "ease-in-out",
    origin: "bottom" //从下到上
};


ScrollReveal().reveal(".feature", {...staggeringOption, interval: 350}); //等350ms出现下一个
ScrollReveal().reveal(".service-item", {...staggeringOption, interval: 350});
const dataSectionEl = document.querySelector(".data-section");
// 数据部分的数字增长动画
ScrollReveal().reveal(".data-section", {
    beforeReveal: () => {
        anime({
            targets: ".data-piece .num",
            innerHTML: el => {
                return [0, el.innerHTML];
            },
            duration: 2000,
            round: 1, //按整数增长
            easing: "easeInExpo" //越来越快的动画效果
        });
        dataSectionEl.style.backgroundPosition = "center calc(50% - ${dataSectionEl.getBoundingClientRect().bottom / 5}px)";
    }
});
// 数据部分的背景时差

window.addEventListener("scroll", () => {
    const bottom = dataSectionEl.getBoundingClientRect().bottom;
    const top = dataSectionEl.getBoundingClientRect().top;

    if (bottom >= 0 && top <= window.innerHeight) {
        dataSectionEl.style.backgroundPosition = "center calc(50% - ${bottom/5}px)";
    }
});


// 实现smooth-scroll的实例
const scroll = new SmoothScroll('nav a[href*="#"], .scrollToTop a[href*="#"]', {
    header: "header",
    offset: 80  //滚动到该区域后多向下滚动80px
});

//关闭全屏导航
document.addEventListener("scrollStart", () => {
    if (headerEl.classList.contains("open")) {
        headerEl.classList.remove("open");
    }
})


//给“探索更多”按钮加上监听事件，使其转到“关于我们”部分
const exploreBtnEls = document.querySelectorAll(".explore-btn");
exploreBtnEls.forEach(exploreBtnEl => {
    exploreBtnEl.addEventListener("click", () => {
        scroll.animateScroll(document.querySelector("#about-us"));
    })
})


// 折叠按钮的实例
const burgerEl = document.querySelector(".burger");
burgerEl.addEventListener("click", () => {
    headerEl.classList.toggle("open");
})
