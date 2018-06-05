
Pod::Spec.new do |s|
  s.name         = "RNReactNativeCheckAccessibility"
  s.version      = "1.0.0"
  s.summary      = "RNReactNativeCheckAccessibility"
  s.description  = <<-DESC
                  RNReactNativeCheckAccessibility
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNReactNativeCheckAccessibility.git", :tag => "master" }
  s.source_files  = "RNReactNativeCheckAccessibility/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

  