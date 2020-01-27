DESCRIPTION = "ChirpStack Gateway Bridge"
HOMEPAGE = "https://www.chirpstack.io/"
PRIORITY = "optional"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=99e425257f8a67b7efd81dc0009ed8ff"
SRC_URI = "https://artifacts.chirpstack.io/downloads/chirpstack-gateway-bridge/chirpstack-gateway-bridge_${PV}_linux_armv5.tar.gz \
           file://chirpstack-gateway-bridge.toml \
           file://chirpstack-gateway-bridge.init \
           file://chirpstack-gateway-bridge.monit \
"
SRC_URI[md5sum] = "1a9bcb8b0d3cc7bf85587dc721263b47"
SRC_URI[sha256sum] = "6775dad166c718d694afed9717ecd6dfb3c95bf9a50074f424eb2f784bea9f4e"
PR = "r1"

inherit update-rc.d

INITSCRIPT_NAME = "chirpstack-gateway-bridge"
INITSCRIPT_PARAMS = "defaults"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 chirpstack-gateway-bridge ${D}${bindir}

    install -d ${D}${sysconfdir}/chirpstack-gateway-bridge
    install -m 0640 ${WORKDIR}/chirpstack-gateway-bridge.toml ${D}${sysconfdir}/chirpstack-gateway-bridge/chirpstack-gateway-bridge.toml

    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/chirpstack-gateway-bridge.init ${D}${sysconfdir}/init.d/chirpstack-gateway-bridge

    install -d ${D}${sysconfdir}/monit.d
    install -m 0644 ${WORKDIR}/chirpstack-gateway-bridge.monit ${D}${sysconfdir}/monit.d/chirpstack-gateway-bridge
}

CONFFILES_${PN} += "${sysconfdir}/chirpstack-gateway-bridge/chirpstack-gateway-bridge.toml"