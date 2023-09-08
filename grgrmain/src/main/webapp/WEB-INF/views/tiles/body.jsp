<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="kor">
<body>

	<section id="main-features ">
		<div class="container ">
			<div class="row mb-100">
				<div class="col-md-3">
					<div class="b-5 border-light rounded-10 raised move">
						<a href="components.html"><img src="${pageContext.request.contextPath}/assets/images/white.png" alt="components" class="rounded"></a>
					</div>
					<!-- / promo-box -->
				</div>
				<!-- / column -->

                    <div class="col-md-3">
                        <div class="b-5 border-light rounded-10 raised move">
                           <a href="sections.html"><img src="${pageContext.request.contextPath}/assets/images/placeholder.jpg" alt="sections" class="rounded"></a>
                        </div><!-- / promo-box -->
                    </div><!-- / column -->

                    <div class="col-md-3">
                        <div class="b-5 border-light rounded-10 raised move">
                           <a href="templates.html"><img src="${pageContext.request.contextPath}/assets/images/placeholder.jpg" alt="templates" class="rounded"></a>
                        </div><!-- / promo-box -->
                    </div><!-- / column -->
                    
                    <div class="col-md-3">  <!-- _______.html 연결할 게시판 -->
                        <div class="b-5 border-light rounded-10 raised move">
                           <a href="templates.html"><img src="${pageContext.request.contextPath}/assets/images/placeholder.jpg" alt="templates" class="rounded"></a>
                        </div><!-- / promo-box -->
                    </div><!-- / column -->
              	</div>
              
               	<div class="container">
                    <div class="row mb-100">
		              	<div class="section-title-area text-center relative z-index-1 mb-50">
		                    <h3 class="section-title">GRGR 인기글</h3>
		                </div>
 
		                <div id="posts-carousel" class="row owl-carousel owl-theme mb-50">
		                    <div class="card bg-img" style="background-image: url(${pageContext.request.contextPath}/assets/images/placeholder-square.jpg)">
		                        <div class="card-header bg-transparent b-0">
		                            <p><i class="fas fa-tag mr-5 text-primary"></i> <span class="secondary-font mr-15">News</span> <i class="far fa-calendar-alt mr-5 text-primary"></i> <span class="secondary-font">Jul 22, 2020</span></p>
		                        </div><!-- / card-header -->
		                        <div class="card-body pt-150 pb-20">
		                            <a href="#x" class="fs-20 fw-bold d-block text-black primary-hover secondary-font mt-10 mb-0">Web Design Trends</a>
		                            <p class="card-text mt-10 mb-0">Donec posuere turpis non elementum bibendum. Vivamus pulvinar tortor ac libero.</p>
		                        </div><!-- / card-body -->
		                    </div><!-- / card -->
		
		                    <div class="card bg-img" style="background-image: url(${pageContext.request.contextPath}/assets/images/placeholder-square.jpg)">
		                        <div class="card-header bg-transparent b-0">
		                            <p><i class="fas fa-tag mr-5 text-primary"></i> <span class="secondary-font mr-15">Tutorials</span> <i class="far fa-calendar-alt mr-5 text-primary"></i> <span class="secondary-font">Jul 22, 2020</span></p>
		                        </div><!-- / card-header -->
		                        <div class="card-body pt-150 pb-20">
		                            <a href="#x" class="fs-20 fw-bold d-block text-black primary-hover secondary-font mt-10 mb-0">How to design a website</a>
		                            <p class="card-text mt-10 mb-0">Donec posuere turpis non elementum bibendum. Vivamus pulvinar tortor ac libero.</p>
		                        </div><!-- / card-body -->
		                    </div><!-- / card -->
		
		                    <div class="card bg-img" style="background-image: url(${pageContext.request.contextPath}/assets/images/placeholder-square.jpg)">
		                        <div class="card-header bg-transparent b-0">
		                            <p><i class="fas fa-tag mr-5 text-primary"></i> <span class="secondary-font text-secondary mr-15">Design</span> <i class="far fa-calendar-alt mr-5 text-primary"></i> <span class="secondary-font">Jul 22, 2020</span></p>
		                        </div><!-- / card-header -->
		                        <div class="card-body pt-150 pb-20">
		                            <a href="#x" class="fs-20 fw-bold d-block text-black primary-hover secondary-font mt-10 mb-0">Branding ideas for 2020</a>
		                            <p class="card-text mt-10 mb-0">Donec posuere turpis non elementum bibendum. Vivamus pulvinar tortor ac libero.</p>
		                        </div><!-- / card-body -->
		                    </div><!-- / card -->
						</div><!-- / posts-carousel -->

                      </div><!-- / card-body -->
                  </div><!-- / card -->
			</div><!-- / posts-carousel -->
		</section>


<!-- core JavaScript -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<!-- / core JavaScript -->

<!-- preloader -->
<script src="${pageContext.request.contextPath}/assets/js/preloader.js"></script>
<!-- / preloader -->

<!-- smooth scroll -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/smooth-scroll.js"></script>
<!-- / smooth scroll -->

<!-- hide nav -->
<script src="${pageContext.request.contextPath}/assets/js/hide-nav.js"></script>
<!-- / hide nav -->

<!-- form validation -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/form-validation.js"></script>
<!-- end of form validation -->

<!-- Owl Carousel -->
<script src="${pageContext.request.contextPath}/assets/js/owl.carousel.min.js"></script>
<script>
$('#carousel-auto').owlCarousel({
    loop:true,
    margin:0,
    nav:false,
    dots:true,
    items:1,
    animateIn: 'fadeIn',
    animateOut: 'fadeOut'
})
</script>

<script>
$('#projects-carousel').owlCarousel({
    loop:true,
    margin:15,
    responsive:{
        0:{
            items:1
        },
        600:{
            items:2
        },
        1000:{
            items:3
        }
    }
})
</script>

<script>
$('#posts-carousel').owlCarousel({
    loop:true,
    margin:15,
    responsive:{
        0:{
            items:1
        },
        600:{
            items:2
        },
        1000:{
            items:3
        }
    }
})
</script>

<script>
$('#testimonial-carousel').owlCarousel({
    loop:true,
    margin:30,
    smartSpeed: 700,
    responsive:{
        0:{
            items:1
        },
        600:{
            items:2
        },
        1000:{
            items:3
        }
    }
})
</script>

<script>
$('#testimonial-slider').owlCarousel({
    loop:true,
    margin:10,
    nav:true,
    dots:false,
    navText:["<i class='fas fa-chevron-left title-color'></i>","<i class='fas fa-chevron-right title-color'></i>"],
    items:1,
    smartSpeed: 1200
})
</script>
<!-- / Owl Carousel -->

<!-- counter -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.countTo.js"></script>
 <script>
      $('.timer').countTo({
        refreshInterval: 60,
        formatter: function (value, options) {
          return value.toFixed(options.decimals);
        },
      });
</script>
<!-- / counter -->

<!-- portfolio script -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.shuffle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/portfolio.js"></script>
<script>
$(document).ready(function(){
    if (Modernizr.touch) {
        // show the close overlay button
        $(".close-overlay").removeClass("hidden");
        // handle the adding of hover class when clicked
        $(".img").click(function(e){
            if (!$(this).hasClass("hover")) {
                $(this).addClass("hover");
            }
        });
        // handle the closing of the overlay
        $(".close-overlay").click(function(e){
            e.preventDefault();
            e.stopPropagation();
            if ($(this).closest(".img").hasClass("hover")) {
                $(this).closest(".img").removeClass("hover");
            }
        });
    } else {
        // handle the mouseenter functionality
        $(".img").mouseenter(function(){
            $(this).addClass("hover");
        })
        // handle the mouseleave functionality
        .mouseleave(function(){
            $(this).removeClass("hover");
        });
    }
});
</script>
<!-- / portfolio script -->

<!-- lightbox -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.magnific-popup.min.js"></script>
<script>
// This will create a single gallery from all elements that have class "lightbox"
$('.lightbox').each(function() {
    $(this).magnificPopup({
        delegate: 'a.image-lightbox', // the selector for gallery item
        type: 'image',
        removalDelay: 500,
        mainClass: 'mfp-fade',
        gallery: {
          enabled:true
        }
    });
});
</script>
<!-- / Owl Carousel -->

</body>

</html>