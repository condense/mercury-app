
deps:
	rm -fr node_modules
	yarn
	patch node_modules/metro/src/JSTransformer/worker.js ./worker.patch

release-android:
	if [ ! -f android/app/aluminium-release-key.keystore ] ; then exit 1; fi;
	lein do clean, with-profile advanced cljsbuild once android
	cd android && ./gradlew assembleRelease

update-android-icons:
	convert artwork/ic_launcher.png       -resize 72x72     android/app/src/main/res/mipmap-hdpi/ic_launcher.png
	convert artwork/ic_launcher.png       -resize 48x48     android/app/src/main/res/mipmap-mdpi/ic_launcher.png
	convert artwork/ic_launcher.png       -resize 96x96     android/app/src/main/res/mipmap-xhdpi/ic_launcher.png
	convert artwork/ic_launcher.png       -resize 144x144   android/app/src/main/res/mipmap-xxhdpi/ic_launcher.png
	convert artwork/ic_launcher.png       -resize 192x192   android/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png
	convert artwork/ic_launcher.png       -resize 1024x1024 android/app/src/main/res/ic_launcher-web.png
	convert artwork/ic_launcher_round.png -resize 72x72     android/app/src/main/res/mipmap-hdpi/ic_launcher_round.png
	convert artwork/ic_launcher_round.png -resize 48x48     android/app/src/main/res/mipmap-mdpi/ic_launcher_round.png
	convert artwork/ic_launcher_round.png -resize 96x96     android/app/src/main/res/mipmap-xhdpi/ic_launcher_round.png
	convert artwork/ic_launcher_round.png -resize 144x144   android/app/src/main/res/mipmap-xxhdpi/ic_launcher_round.png
	convert artwork/ic_launcher_round.png -resize 192x192   android/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png

update-ios-icons:
	convert artwork/icon.png -resize 40x40      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-20x20@2x.png
	convert artwork/icon.png -resize 60x60      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-20x20@3x.png
	convert artwork/icon.png -resize 58x58      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-29x29@2x.png
	convert artwork/icon.png -resize 87x87      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-29x29@3x.png
	convert artwork/icon.png -resize 80x80      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-40x40@2x.png
	convert artwork/icon.png -resize 120x120    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-40x40@3x.png
	convert artwork/icon.png -resize 120x120    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-60x60@2x.png
	convert artwork/icon.png -resize 180x180    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/iphone-60x60@3x.png
	convert artwork/icon.png -resize 20x20      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-20x20@1x.png
	convert artwork/icon.png -resize 40x40      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-20x20@2x.png
	convert artwork/icon.png -resize 29x29      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-29x29@1x.png
	convert artwork/icon.png -resize 58x58      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-29x29@2x.png
	convert artwork/icon.png -resize 40x40      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-40x40@1x.png
	convert artwork/icon.png -resize 80x80      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-40x40@2x.png
	convert artwork/icon.png -resize 76x76      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-76x76@1x.png
	convert artwork/icon.png -resize 152x152    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-76x76@2x.png
	convert artwork/icon.png -resize 167x167    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ipad-83.5x83.5@2x.png
	convert artwork/icon.png -resize 1024x1024  ios/MercuryApp/Images.xcassets/AppIcon.appiconset/ios-marketing-1024x1024@1x.png
