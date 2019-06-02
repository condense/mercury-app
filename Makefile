
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
	convert artwork/icon.png -resize 40x40      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-20@2x.png
	convert artwork/icon.png -resize 60x60      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-20@3x.png
	convert artwork/icon.png -resize 58x58      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-29@2x.png
	convert artwork/icon.png -resize 87x87      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-29@3x.png
	convert artwork/icon.png -resize 80x80      ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-40@2x.png
	convert artwork/icon.png -resize 120x120    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-40@3x.png
	convert artwork/icon.png -resize 120x120    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-60@2x.png
	convert artwork/icon.png -resize 180x180    ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-60@3x.png
	convert artwork/icon.png -resize 1024x1024  ios/MercuryApp/Images.xcassets/AppIcon.appiconset/Icon-1024.png
