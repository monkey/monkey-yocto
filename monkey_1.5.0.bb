SUMMARY = "Fast and Lightweight HTTP Server for Linux"
HOMEPAGE = "http://monkey-project.com"
BUGTRACKER = "https://github.com/monkey/monkey/issues"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

PR = "r1"

SECTION = "net"
DEPENDS = ""

SRC_URI = "http://monkey-project.com/releases/1.5/monkey-${PV}.tar.gz"
SRC_URI[md5sum] = "61cb1b216121dd8e9ff304aa8a5b587b"
SRC_URI[sha256sum] = "77717912ff76fd3a294ec0b082a0d55ec2ceea18579311814bdff2e1c577c2b3"

EXTRA_OECONF = " \
             --bindir=/usr/bin/ \
             --plugdir=/usr/lib/monkey/ \
             --logdir=/var/log/monkey/ \
             --pidfile=/var/run/monkey.pid \
             --default-user=www-data \
             --datadir=/var/www/monkey/ \
             --sysconfdir=/etc/monkey/ \
             --enable-plugins=* \
             --disable-plugins=polarssl \
             --debug \
             --malloc-libc \
"

inherit autotools pkgconfig update-rc.d systemd

INITSCRIPT_NAME = "monkey"
INITSCRIPT_PARAMS = "defaults 70"

SYSTEMD_SERVICE_${PN} = "monkey.service"

FILES_${PN} += "${sysconfdir} /www"

CONFFILES_${PN} = "${sysconfdir}/monkey/"

PACKAGES_DYNAMIC += "^monkey-.*"

do_install() {
   DESTDIR=${D} oe_runmake install
}
