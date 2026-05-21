# appleskin-plugin

Paper鯖で AppleSkin の saturation (隠し満腹度) と exhaustion (疲労度)を同期するプラグインです。

Paper 1.21.11 + Java 25 専用です。
個人用なので他バージョン対応予定はないです。

## 作った理由

自鯖で AppleSkin をちゃんと使いたかったんですが、
プラグイン鯖向けだと [AppleSkin-Spigot](https://github.com/jmattingley23/AppleSkinSpigot) くらいしか見つからなくて、
それが古い channel ID 使ってて動かなかったので作りました。

中身は [AppleSkin-Spigot](https://github.com/jmattingley23/AppleSkinSpigot) をかなり参考にしてます。

あと自分しか使わないので `appleskin:natural_regeneration` は実装してません。

saturation / exhaustion は同期されるので、
普通に使う分にはそこまで困らないと思います。

## 依存

- Java 25
- Paper 1.21.11
- Maven 3.9+

## Build

```bash
git clone https://github.com/ryusei-sky/appleskin-plugin.git
cd appleskin-plugin
mvn clean package
```
