<%@include file="/apps/tourismaustralia/components/global.jsp"%>


<body>
	<cq:include path="clientcontext"
		resourceType="cq/personalization/components/clientcontext" />
	<cq:include script="customProperties.jsp" />

	<div class="site-wrapper l-overflow-x-hidden">

        <cq:include script="header.jsp" />

        <cq:include script="content.jsp" />

    </div>

	<footer id="main-footer" class="site-footer">

			<div class="footer-container">
				<div class="footer">

					<div class="row footer-logo">


						<img id="logo" src="/etc/designs/tourismaustralia/clientlibs/imgs/logo/logo_australia_com_whitetext.png"
							alt="" />
					</div>

					<div class="row l-padding-lr-10">
						<div class="col-xs-12 col-sm-6 col-md-4 1col-sm-3">


							<div class="footer-col">
								<p class="footer-heading">Change your country and language</p>

								<div class="row">
									<div class="col-xs-12 type-spacing-20">

										<div class="dropdown-select-countrylanguage">
											<div class="dropdown-select-countrylanguage-style">
												<select>


													<option>United States of America</option>

													<option>Australia</option>


												</select>
											</div>
										</div>


									</div>

									<div class="col-xs-12">



										<div class="dropdown-select-countrylanguage">
											<div class="dropdown-select-countrylanguage-style">
												<select>


													<option>International English</option>

													<option>German</option>


												</select>
											</div>
										</div>


									</div>
								</div>

							</div>

						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 1col-sm-4">


							<div class="footer-col">
								<p class="footer-heading">Find us on</p>
								<ul class="footer-social-list">
									<li><a href="https://www.facebook.com/seeaustralia"
										class="btn-share"><span><img
												src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/footer/footer-fb-icon.png" alt="" />Facebook</span></a></li>
									<li><a href="https://plus.google.com/+australia/posts"
										class="btn-share"><span><img
												src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/footer/footer-gplus-icon.png" alt="" />Google
												+</span></a></li>
									<li><a href="http://instagram.com/australia"
										class="btn-share"><span><img
												src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/footer/footer-instagram-icon.png" alt="" />Instagram</span></a></li>
									<li><a href="https://twitter.com/australia"
										class="btn-share"><span><img
												src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/footer/footer-twitter-icon.png" alt="" />Twitter</span></a></li>
									<li><a href="https://www.youtube.com/user/australia"
										class="btn-share"><span><img
												src="/etc/designs/tourismaustralia/clientlibs/imgs/icons/footer/footer-yt-icon.png" alt="" />Youtube</span></a></li>
								</ul>
							</div>

						</div>
						<div
							class="col-xs-12 col-sm-12 col-md-4 l-clear-padding l-push-up-xs--1">
							<div class="col-xs-12 col-sm-6">


								<div class="footer-col">
									<p class="footer-heading">About this site</p>
									<ul class="footer-text-list footer-type-light l-list-clean">
										<li><a href="#">Sitemap</a></li>
										<li><a href="http://www.australia.com/privacypolicy.aspx">Privacy
												policy</a></li>
										<li><a
											href="http://www.australia.com/terms-conditions.aspx">Terms
												& conditions</a></li>
										<li><a href="#">Special offers disclaimer</a></li>
										<li><a href="#">Feedback</a></li>
									</ul>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6">


								<div class="footer-col">
									<p class="footer-heading">Other Sites</p>
									<ul class="footer-text-list l-list-clean">
										<li><a href="#">Media & industry</a></li>
										<li><a href="#">Business events</a></li>
									</ul>
									<div class="footer-copyright">� Tourism Australia 2014</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</footer>


    <script type="text/javascript">
        $(document).ready(function() {

            //Hack for IE-8 to show placeholder
            $('form').cstmForm({
                active: 1,
                text: {
                    force: true
                }
            });
        });

        //Hack for mobile detection
        function checkPlatform() {
            return (/Android|iPhone|iPad|iPod|BlackBerry/i).test(navigator.userAgent || navigator.vendor || window.opera);
        }

        $(window).load(function(){
            if(!checkPlatform()) {
                var s = skrollr.init();
            }
        });
    </script>

</body>